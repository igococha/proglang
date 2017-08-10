package ast;
import visitor.*;

public class IdExp extends Exp {
   public String id;
   public IdExp(String i) {id=i;}
   public int accept(Visitor v) throws VisitorException
    {  return v.visit(this); }
}



