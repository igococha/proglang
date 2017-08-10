package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class DoWhile extends Statement {
  public Statement s;
  public Exp e;

  public DoWhile(Statement as, Exp ae) {
    s=as; e=ae;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

