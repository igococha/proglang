/* Generated By:JJTree: Do not edit this line. ASTMul.java */

public class ASTMul extends SimpleNode {
  public ASTMul(int id) {
    super(id);
  }

  public ASTMul(TPLParser p, int id) {
    super(p, id);
  }

  /* Added by DB to perform identification and type checking. */

  public void identification () {
    jjtGetChild(0).identification();
    jjtGetChild(1).identification();
  }

  public void typecheck () {
    jjtGetChild(0).typecheck();
    jjtGetChild(1).typecheck();
    if (!(jjtGetChild(0).GetNodeType() == TPLTypes.intType &&
          jjtGetChild(1).GetNodeType() == TPLTypes.intType))
       System.out.println("TPL Typechecker: mult of non-ints.");
    NodeType = TPLTypes.intType;
  }

  /* Added by DB to perform interpreting. */

  public void interpret () {
    int left, right;
    jjtGetChild(0).interpret();
    jjtGetChild(1).interpret();

    right = ((Integer)stack.pop()).intValue();
    left = ((Integer)stack.pop()).intValue();

    stack.push(new Integer(left*right));
  }
 
}