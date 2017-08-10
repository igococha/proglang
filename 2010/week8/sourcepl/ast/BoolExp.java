package ast;
import visitor.*;


public class BoolExp extends Exp {
    public enum BOp { AND, OR };
    public Exp left, right; 
    public BOp oper;
    public BoolExp(Exp l, BOp o, Exp r) {left=l; oper=o; right=r;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


