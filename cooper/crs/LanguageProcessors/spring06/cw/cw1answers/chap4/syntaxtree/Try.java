package syntaxtree;
import visitor.Visitor;

public class Try extends Statement {	/* Added by DB */
  public StatementList sl1;
  public CatchList  cl;
  public StatementList sl2;

  public Try(StatementList ts, CatchList cs, StatementList fs) {
    sl1=ts; cl=cs; sl2=fs;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

}

