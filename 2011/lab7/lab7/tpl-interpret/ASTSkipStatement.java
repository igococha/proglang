/* Generated By:JJTree: Do not edit this line. ASTSkipStatement.java */

public class ASTSkipStatement extends SimpleNode {
  public ASTSkipStatement(int id) {
    super(id);
  }

  public ASTSkipStatement(TPLParser p, int id) {
    super(p, id);
  }

  public void typecheck () {
    NodeType = TPLTypes.stmType;
  }

  public void interpret () {	/* Do nothing. */
  }

}
