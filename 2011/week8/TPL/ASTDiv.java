/* Generated By:JJTree: Do not edit this line. ASTDiv.java */

public class ASTDiv extends SimpleNode {
  public ASTDiv(int id) {
    super(id);
  }

  public ASTDiv(TPLParser p, int id) {
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
       System.out.println("TPL Typechecker: division of non-ints.");
    NodeType = TPLTypes.intType;
  }

}
