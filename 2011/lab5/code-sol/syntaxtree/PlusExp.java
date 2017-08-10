package syntaxtree;

public class PlusExp extends Exp {
  public Exp e1, e2;
  public PlusExp(Exp a1, Exp a2) { e1=a1; e2=a2; }
  public int evaluate() { 
      return e1.evaluate() + e2.evaluate();
  }
}

