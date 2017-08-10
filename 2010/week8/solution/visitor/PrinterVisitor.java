package visitor;

import ast.*;
import java.util.*;

public class PrinterVisitor implements Visitor {
    String indent = "";
    void incIndent() { indent = indent + "  "; }
    void decIndent() { if (indent != "") indent = indent.substring(2); }

    public int visit(Program p) throws VisitorException {
	return p.mainf.accept(this);
    }

    public int visit(MainFunction m) throws VisitorException {
	Stm s;
	System.out.println("void main() {");
	Iterator<String> itvars = m.vars.iterator();
	while (itvars.hasNext()){
	    System.out.println("int "+itvars.next()+";");
	}
	incIndent();
	Iterator<Stm> iterator = m.statements.iterator();
	while (iterator.hasNext()){
	    s = iterator.next();
	    s.accept(this);
	}
	decIndent();
	System.out.println("}");
	return 0;
    }

    public int visit(PrintStm s) throws VisitorException {
	System.out.print(indent+"print(");
	s.exp.accept(this);
	System.out.println(");");
	return 0;
    }

    public int visit(AssignStm s) throws VisitorException {
	System.out.print(indent+s.id+" :=  ");
	s.exp.accept(this);
	System.out.println(";");
	return 0;
    }

    public int visit(IfStm s) throws VisitorException {
	System.out.print(indent+"if (");
	s.exp.accept(this);
	System.out.println(") then {");
	incIndent();
	Iterator<Stm> iterator = s.ls1.iterator();
	while (iterator.hasNext()){
	    (iterator.next()).accept(this);
	}
	if (s.ls2 != null) {
	    decIndent();
	    System.out.println(indent+"} else {");
	    incIndent();
	    iterator = s.ls2.iterator();
	    while (iterator.hasNext()){
		(iterator.next()).accept(this);
	    }
	}
	decIndent();
	System.out.println(indent+"}");
	return 0;
    }

public int visit(WhileStm s) throws VisitorException {
	System.out.print(indent+"while (");
	s.exp.accept(this);
	System.out.println(")  {");
	incIndent();
	Iterator<Stm> iterator = s.body.iterator();
	while (iterator.hasNext()){
	    (iterator.next()).accept(this);
	}
	decIndent();
	System.out.println(indent+"}");
	return 0;
    }

    public int visit(IdExp e) throws VisitorException {
	System.out.print(e.id);
	return 0;
    }

    public int visit(OpExp e) throws VisitorException {
	System.out.print("(");
	e.left.accept(this);
	String op;
	switch(e.oper) {
	case PLUS:  op = " + "; break;
	case MINUS: op = " - "; break;
	case TIMES: op = " * "; break;
	case DIV: op = " / "; break;
	default: throw new VisitorException("Unknown Symbol");  // unknown
	}
	System.out.print(op);
	e.right.accept(this);
	System.out.print(")");
	return 0;
    }

    public int visit(CmpExp e) throws VisitorException {
	System.out.print("(");
	e.left.accept(this);
	String op;
	switch(e.oper) {
	case GT:  op = " > "; break;
	case GEQ: op = " >= "; break;
	case EQ: op = " == "; break;
	default:  throw new VisitorException("Unknown Symbol");    // unknown
	}
	System.out.print(op);
	e.right.accept(this);
	System.out.print(")");
	return 0;
    }

    public int visit(BoolExp e) throws VisitorException {
	System.out.print("(");
	e.left.accept(this);
	String op;
	switch(e.oper) {
	case AND:  op = " and "; break;
	case OR: op = " or "; break;
	default:  throw new VisitorException("Unknown Symbol");   // unknown
	}
	System.out.print(op);
	e.right.accept(this);
	System.out.print(")");
	return 0;
    }

    public int visit(IntLiteralExp e) throws VisitorException {
	System.out.print(e.num);
	return 0;
    }

    public int visit(BoolLiteralExp e) throws VisitorException {
	if (e.value)
	    System.out.print("true");
	else
	    System.out.print("false");
	return 0;
    }

    public int visit(NotExp e) throws VisitorException {
	System.out.print("!");
	e.exp.accept(this);
	return 0;
    }


}
