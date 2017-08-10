package visitor;
import syntaxtree.*;

public class TypeCheckExpVisitor extends TypeDepthFirstVisitor {
   

  // Exp e1,e2;
  public Type visit(And n) {
    if (! (n.e1.accept(this) instanceof BooleanType) ) {
       System.out.println("Left side of And must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof BooleanType) ) {
       System.out.println("Right side of And must be of type integer");
       System.exit(-1);
    }
    return new BooleanType();
  }

  // Exp e1,e2;
  public Type visit(Or n) {	/* Added by DB */
    if (! (n.e1.accept(this) instanceof BooleanType) ) {
       System.out.println("Left side of Or must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof BooleanType) ) {
       System.out.println("Right side of Or must be of type integer");
       System.exit(-1);
    }
    return new BooleanType();
  }

  // Exp e1,e2;
  public Type visit(LessThan n) {
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of LessThan must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of LessThan must be of type integer");
       System.exit(-1);
    }
    return new BooleanType();
  }

  // Exp e1,e2;
  public Type visit(GreaterThan n) {	/* Added by DB */
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of GreaterThan must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of GreaterThan must be of type integer");
       System.exit(-1);
    }
    return new BooleanType();
  }

  // Exp e1,e2;
  public Type visit(Plus n) {
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of Plus must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of Plus must be of type integer");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e1,e2;
  public Type visit(Minus n) {
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of Minus must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of Minus must be of type integer");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e1,e2;
  public Type visit(Times n) {
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of Times must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of Times must be of type integer");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e1,e2;
  public Type visit(Divide n) {		/* Added by DB */
    if (! (n.e1.accept(this) instanceof IntegerType) ) {
       System.out.println("Left side of Divide must be of type integer");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("Right side of Divide must be of type integer");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e1,e2,e3;
  public Type visit(ShortCutIfElse n) {
    if (! (n.e1.accept(this) instanceof BooleanType) ) {
       System.out.println("First expression in shortcut" +
                          " if-else must be of type boolean");
       System.exit(-1);
    }
    Type t1 = n.e2.accept(new TypeCheckExpVisitor() );
    Type t2 = n.e3.accept(new TypeCheckExpVisitor() );
    if (TypeCheckVisitor.symbolTable.compareTypes(t1,t2)==false){
        System.out.println("Second and third expressions in shortcut" +
                           " if-else must be of same type");      
        System.exit(0);
    }
    return t1;
  }
    
  // Exp e1,e2;
  public Type visit(ArrayLookup n) {
    if (! (n.e1.accept(this) instanceof IntArrayType) ) {
       System.out.println("target of ArrayLookup must be of type IntArray");
       System.exit(-1);
    }
    if (! (n.e2.accept(this) instanceof IntegerType) ) {
       System.out.println("ArrayLookup index must be of type integer");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e;
  public Type visit(ArrayLength n) {
    if (! (n.e.accept(this) instanceof IntArrayType) ) {
       System.out.println("target of ArrayLength must of type Array");
       System.exit(-1);
    }
    return new IntegerType();
  }

  // Exp e;
  // Identifier i;
  // ExpList el;
  public Type visit(Call n) {

    if (! (n.e.accept(this) instanceof IdentifierType)){
	System.out.println("method "+ n.i.toString() 
			   + "called  on something that is not a"+
			   " class or Object.");
	System.exit(-1);
    } 

    String mname = n.i.toString();    
    String cname = ((IdentifierType) n.e.accept(this)).s;

    Method calledMethod = TypeCheckVisitor.symbolTable.getMethod(mname,cname);
    
    for ( int i = 0; i < n.el.size(); i++ ) {     	
	Type t1 =null;  
	Type t2 =null;  

	if (calledMethod.getParamAt(i)!=null)
	    t1 = calledMethod.getParamAt(i).type();
	t2 = n.el.elementAt(i).accept(this);
	if (!TypeCheckVisitor.symbolTable.compareTypes(t1,t2)){
	    System.out.println("Type Error in arguments passed to " +
			       cname+"." +mname);
	    System.exit(-1);  
	}	    
    }

    return TypeCheckVisitor.symbolTable.getMethodType(mname,cname);
  }

  // int i;
  public Type visit(IntegerLiteral n) {
    return new IntegerType();
  }

  public Type visit(True n) {
    return new BooleanType();
  }

  public Type visit(False n) {
    return new BooleanType();
  }

  // String s;
  public Type visit(IdentifierExp n) {      
    return TypeCheckVisitor.symbolTable.getVarType(TypeCheckVisitor.currMethod,
		      TypeCheckVisitor.currClass,n.s);
  }

  public Type visit(This n) {
      return TypeCheckVisitor.currClass.type();
  }

  // Exp e;
  public Type visit(NewArray n) {
    
    if (! (n.e.accept(this) instanceof IntegerType) ) {
       System.out.println("Array expression in NewArray must be of type integer");
       System.exit(-1);
    }
    return new IntArrayType();
  }

  // Identifier i;
  public Type visit(NewObject n) {
    return new IdentifierType(n.i.s);
  }

  // Exp e;
  public Type visit(Not n) {
    if (! (n.e.accept(this) instanceof BooleanType) ) {
       System.out.println("Not expression must be of type boolean");
       System.exit(-1);
    }
    return new BooleanType();
  }

}
 //TypeCheckVisitor.






