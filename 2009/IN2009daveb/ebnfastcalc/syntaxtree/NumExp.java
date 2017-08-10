package syntaxtree;

public class NumExp  extends Exp {
  private String f0;
  public NumExp (String n0) { f0=n0; }
  public int eval() { 
    return Integer.parseInt(f0);
  }
}
