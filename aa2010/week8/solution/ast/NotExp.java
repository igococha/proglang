package ast;
import visitor.*;


public class NotExp extends Exp {
    public Exp exp; 
    public NotExp(Exp e) { exp = e; }
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


