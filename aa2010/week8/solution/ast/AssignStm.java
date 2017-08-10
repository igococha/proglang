package ast;
import visitor.*;

public class AssignStm extends Stm {
    public String id; 
    public Exp exp;
    public AssignStm(String i, Exp e) {id=i; exp=e;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


