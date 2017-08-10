package ast;
import visitor.*;


public class CmpExp extends Exp {
    public enum COp { GT,GEQ, EQ };
    public Exp left, right; 
    public COp oper;
    public CmpExp(Exp l, COp o, Exp r) {left=l; oper=o; right=r;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


