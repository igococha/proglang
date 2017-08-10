package syntaxtree;

import visitor.*;

public class NumExp  extends Exp {
  public String f0;
  public NumExp (String n0) { f0=n0; }
  public int accept(Visitor v) { 
    return v.visit(this);
  }
}
