package ast;
import visitor.*;

public class BoolLiteralExp extends Exp {
    public boolean value;
    public BoolLiteralExp(boolean b) {value=b;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}



