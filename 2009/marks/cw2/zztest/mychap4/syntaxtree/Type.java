package syntaxtree;
import visitor.Visitor;

public abstract class Type {
  public abstract void accept(Visitor v);
}
