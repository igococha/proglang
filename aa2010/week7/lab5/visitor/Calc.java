package visitor;

import syntaxtree.*;

public class Calc implements Visitor {
  public int visit (PlusExp n) {
    return n.e1.accept(this)+n.e2.accept(this);
  }

  public int visit (MinusExp n) {
    return n.e1.accept(this)-n.e2.accept(this);
  }

  public int visit (TimesExp n) {
    return n.e1.accept(this)*n.e2.accept(this);
  }

  public int visit (DivideExp n) {
    return n.e1.accept(this)/n.e2.accept(this);
  }

  public int visit (NumExp n) {
    return Integer.parseInt(n.f0);
  }
}
