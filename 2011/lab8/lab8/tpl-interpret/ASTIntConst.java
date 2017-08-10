/* Generated By:JJTree: Do not edit this line. ASTIntConst.java */

public class ASTIntConst extends SimpleNode {
  public ASTIntConst(int id) {
    super(id);
  }

  public ASTIntConst(TPLParser p, int id) {
    super(p, id);
  }

 /*
  * Field added to automatically generated class by DB to hold
  * value of constant in node.
  */

  int val;

 /* 
  * Customized dump written by DB to show val in printed tree. 
  * Overrides dump from SimpleNode. This is a leaf so no children to dump.
  */

  public void dump(String prefix) {
    System.out.print(toString(prefix));
    System.out.println(" "+val);
  }

  public void typecheck () {
    NodeType = TPLTypes.intType;
  }

  /* Added by DB to perform interpreting. */

  public void interpret() {
    stack.push(new Integer(val));
  }

}
