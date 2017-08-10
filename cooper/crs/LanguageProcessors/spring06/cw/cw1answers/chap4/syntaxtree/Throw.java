package syntaxtree;
import visitor.Visitor;

public class Throw extends Statement {	/* Added by DB */
  public Exp e;

  public Throw(Exp te) {
    e=te;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

}

