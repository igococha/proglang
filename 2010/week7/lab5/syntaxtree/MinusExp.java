package syntaxtree;

import visitor.*;

public class MinusExp extends Exp {
  public Exp e1, e2;
  public MinusExp(Exp a1, Exp a2) { e1=a1; e2=a2; }
  public int accept(Visitor v) { 
    return v.visit(this);
  }
}

