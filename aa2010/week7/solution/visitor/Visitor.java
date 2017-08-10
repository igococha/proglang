package visitor;

import syntaxtree.*;

public interface Visitor {
  public int visit(PlusExp n);
  public int visit(MinusExp n);
  public int visit(TimesExp n);
  public int visit(DivideExp n);
  public int visit(PowerExp n);
  public int visit(NumExp n);
}

