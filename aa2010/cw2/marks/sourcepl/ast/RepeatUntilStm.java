package ast;
import visitor.*;
import java.util.*;

public class RepeatUntilStm extends Stm {
    public Exp exp1;
    public List<Stm> body; 
    public RepeatUntilStm(List<Stm> b,Exp e1) {body=b;exp1=e1; }
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}
