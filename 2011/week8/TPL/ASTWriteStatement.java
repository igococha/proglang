/* Generated By:JJTree: Do not edit this line. ASTWriteStatement.java */

public class ASTWriteStatement extends SimpleNode {
  public ASTWriteStatement(int id) {
    super(id);
  }

  public ASTWriteStatement(TPLParser p, int id) {
    super(p, id);
  }

 /*
  * Field added to automatically generated class by DB to hold
  * name of variable in node.
  */

  public String name;

  /*
  * Customized dump written by DB to show name in printed tree.
  * Overrides dump from SimpleNode. This is a leaf so no children to dump.
  */

  public void dump(String prefix) {
    System.out.print(toString(prefix));
    System.out.println(" "+name);
  }

  /* Added by DB to perform identification and type checking. */

  public void identification () {
    if (!(symtab.containsKey(name)))
      System.out.println("TPL Identification: "+name+" not declared (write).");
  }

  public void typecheck () { 
    NodeType = TPLTypes.stmType;
  }
}
