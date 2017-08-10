package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class ShortCutIfElse extends Exp {	/* Added by DB */
  public Exp e1, e2, e3;

  public ShortCutIfElse(Exp ec, Exp et, Exp ee) {
    e1=ec; e2=et; e2=ee;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

