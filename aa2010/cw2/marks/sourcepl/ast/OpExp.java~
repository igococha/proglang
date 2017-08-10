package ast;
import visitor.*;


public class OpExp extends Exp {
    public enum AOp { PLUS,MINUS,TIMES,DIV };
    public Exp left, right; 
    public AOp oper;
    public OpExp(Exp l, AOp o, Exp r) {left=l; oper=o; right=r;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


