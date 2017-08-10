package syntaxtree;
import visitor.Visitor;

public class Catch {	/* Added by DB */
  public Type t;
  public Identifier i;
  public StatementList sl;

  public Catch(Type ct, Identifier ci, StatementList cs) {
    t=ct; i=ci; sl=cs;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

}

