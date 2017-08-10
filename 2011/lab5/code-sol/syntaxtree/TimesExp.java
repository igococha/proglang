package syntaxtree;

public class TimesExp extends Exp {
  public Exp e1, e2;
  public TimesExp(Exp a1, Exp a2) { e1=a1; e2=a2; }
  public int evaluate() { 
      return e1.evaluate() * e2.evaluate();
  }
}

