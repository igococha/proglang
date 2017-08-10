package ast;
import visitor.*;

public class PrintStm extends Stm {
    public Exp exp;
    public PrintStm(Exp e) {exp=e;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


