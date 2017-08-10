package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class RepeatUntil extends Statement {
  public Exp e;
  public Statement s;

  public RepeatUntil(Statement as, Exp ae) {
    e=ae; s=as; 
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

