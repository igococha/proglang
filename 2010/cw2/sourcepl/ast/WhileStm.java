package ast;
import visitor.*;
import java.util.*;

public class WhileStm extends Stm {
    public Exp exp;
    public List<Stm> body; 
    public WhileStm(Exp e, List<Stm> b) { exp=e; body=b; }
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


