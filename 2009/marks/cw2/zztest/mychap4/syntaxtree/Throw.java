package syntaxtree;
import visitor.Visitor;

public class Throw extends Statement {
  public Exp e;

  public Throw(Exp ae) {
    e=ae;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

}

 
