/* Generated By:JJTree: Do not edit this line. ASTFalse.java */

public class ASTFalse extends SimpleNode {
  public ASTFalse(int id) {
    super(id);
  }

  public ASTFalse(TPLParser p, int id) {
    super(p, id);
  }

  public void typecheck () {
    NodeType = TPLTypes.boolType;
  }

  /* Added by DB to perform interpreting. */

  public void interpret () {
    stack.push(new Boolean(false));
  }

}
