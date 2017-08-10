package syntaxtree;
import visitor.Visitor;

public class DoWhile extends Statement {	/* Added by DB */
  public Statement s;
  public Exp e;

  public DoWhile(Statement as, Exp ae) {
    s=as; e=ae;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

}

