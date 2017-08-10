package syntaxtree;

public class TimesExp extends Exp {
  private Exp e1, e2;
  public TimesExp(Exp a1, Exp a2) { e1=a1; e2=a2; }
  public int eval() { 
    return e1.eval()*e2.eval();
  }
}

