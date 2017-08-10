package ast;
import visitor.*;

public class IntLiteralExp extends Exp {
    public int num;
    public IntLiteralExp(int n) {num=n;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}



