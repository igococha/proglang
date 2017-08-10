/* Generated By:JJTree: Do not edit this line. ASTIfStatement.java */

public class ASTIfStatement extends SimpleNode {
  public ASTIfStatement(int id) {
    super(id);
  }

  public ASTIfStatement(TPLParser p, int id) {
    super(p, id);
  }

  /* Added by DB to perform identification and type checking. */

  public void identification () {
    jjtGetChild(0).identification();
    jjtGetChild(1).identification();
    if (jjtGetNumChildren() == 3)
       jjtGetChild(2).identification();
  }

  public void typecheck () {
    jjtGetChild(0).typecheck();
    jjtGetChild(1).typecheck();
    if (jjtGetNumChildren() == 3)
       jjtGetChild(2).typecheck();

    if (jjtGetChild(0).GetNodeType() != TPLTypes.boolType)
       System.out.println("TPL Typechecker: if statement condition non-bool");

    NodeType = TPLTypes.stmType;
  }
}
