package visitor;

import ast.*;
import java.util.*;

public class Interpreter implements Visitor {
    enum Type { INT, BOOL, NOTYPE };
    Type valType;
    Table table = new Table();
    PrinterVisitor printer = new PrinterVisitor();

    public int visit(Program p) throws VisitorException {
	return p.mainf.accept(this);
    }

    public int visit(MainFunction m)  throws VisitorException {
	Stm s;
	/* initialise declared vars with 0 */
	Iterator<String> itvars = m.vars.iterator();
	while (itvars.hasNext()){
	    table.update(itvars.next(),0);
	}
	/* Execute statements */
	Iterator<Stm> iterator = m.statements.iterator();
	while (iterator.hasNext()){
	    s = iterator.next();
	    s.accept(this);
	}
	valType=Type.NOTYPE;
	return 0;
    }

    public int visit(PrintStm s)  throws VisitorException {
	int v = s.exp.accept(this);
	System.out.println(v);
	valType=Type.NOTYPE;
	return 0;
    }

    public int visit(AssignStm s) throws VisitorException {
	int v = s.exp.accept(this);
	checkAssignType(s,valType,Type.INT);
	table.update(s.id,v);
	valType=Type.NOTYPE;
	return 0;
    }

    public int visit(IfStm s) throws VisitorException {
	int v = s.exp.accept(this);
	checkExpType(s.exp,s.exp,valType,Type.BOOL);
	Iterator<Stm> iterator;
	if (v!=0) {
	    iterator = s.ls1.iterator();
	    while (iterator.hasNext()){
		iterator.next().accept(this);
	    }
	} else if (s.ls2 != null) {
	    iterator = s.ls2.iterator();
	    while (iterator.hasNext()){
		iterator.next().accept(this);
	    }
	}
	valType=Type.NOTYPE;
	return 0;
    }

   public int visit(WhileStm s) throws VisitorException {
	int v = s.exp.accept(this);
	checkExpType(s.exp,s.exp,valType,Type.BOOL);
	Iterator<Stm> iterator;
	while (v!=0) {
	    iterator = s.body.iterator();
	    while (iterator.hasNext()){
		iterator.next().accept(this);
	    }
	    v = s.exp.accept(this);
	} 

	valType=Type.NOTYPE;
	return 0;
    }

    public int visit(IdExp e) throws VisitorException {
	try {
	    valType=Type.INT;
	    return table.lookup(e.id);
	} catch (TableLookupException ex) {
	    throw new VisitorException("Variable "+e.id+" undefined");
	}
    }

 

    public int visit(OpExp e) throws VisitorException {
	int r=0;
	int v1 = e.left.accept(this);
	checkExpType(e,e.left,valType,Type.INT);
	int v2 = e.right.accept(this);
	checkExpType(e,e.right,valType,Type.INT);
	switch(e.oper) {
	case PLUS: r = v1+v2; break;
	case MINUS: r = v1-v2; break;
	case TIMES: r = v1*v2; break;
	case DIV: if (v2!=0) r = v1/v2; break;
	default:
	    System.out.print("??");  // unknown
	}
	valType = Type.INT;
	return r;
    }

   public int visit(CmpExp e) throws VisitorException {
       boolean r=false;  // result is boolean
       int v1 = e.left.accept(this);
       checkExpType(e,e.left,valType,Type.INT);
       int v2 = e.right.accept(this);
       checkExpType(e,e.right,valType,Type.INT);
       switch(e.oper) {
       case GT: r = (v1 > v2); break;
       case GEQ: r = (v1 >= v2); break;
       case EQ: r = (v1 == v2); break;
       default: System.out.print("??");  // unknown
       }
       valType = Type.BOOL;
       return (r)?1:0;  // final result is sent as int
   }

   public int visit(BoolExp e) throws VisitorException {
       boolean r=false;  // result is boolean
       boolean v1 = (e.left.accept(this)==0)?false:true; // left must be bool
       checkExpType(e,e.left,valType,Type.BOOL);
       boolean v2 = (e.right.accept(this)==0)?false:true;  // right must be bool
       checkExpType(e,e.right,valType,Type.BOOL);
       switch(e.oper) {
       case AND: r = (v1 && v2); break;
       case OR: r = (v1 || v2); break;
       default: System.out.print("??");  // unknown
       }
       valType = Type.BOOL;
       return (r)?1:0;  // final result is sent as int
   }

   public int visit(IntLiteralExp e) throws VisitorException {
       valType = Type.INT;
       return e.num;
    }

   public int visit(BoolLiteralExp e) throws VisitorException {
       valType = Type.BOOL;
       if (e.value) return 1; else return 0;
    }

   public int visit(NotExp e) throws VisitorException {
       int v = e.exp.accept(this);
       checkExpType(e,e.exp,valType,Type.BOOL);
       valType = Type.BOOL;
       if (v==0) return 1; else return 0;
    }

    void checkExpType(Exp e, Exp arg, Type t, Type expected) throws VisitorException 
    {
	if (t != expected) {
	    System.out.print("Wrong Type for ");
	    arg.accept(printer);
	    System.out.print(" in ");
	    e.accept(printer);
	    System.out.print("\n");
	    throw new VisitorException("Type Error");
	}
    }

void checkAssignType(Stm s, Type t, Type expected) throws VisitorException 
    {
	if (t != expected) {
	    System.out.print("Wrong Type of RHS: ");
	    s.accept(printer);
	    System.out.println("Expected int");
	    throw new VisitorException("Type Error");
	}
    }
}
