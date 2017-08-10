package ast;
import visitor.*;
import java.util.*;

public class IfStm extends Stm {
    public Exp exp;
    public List<Stm> ls1,ls2; 
    public IfStm(Exp e, List<Stm> l1, List<Stm> l2) { exp=e; ls1=l1; ls2=l2; }
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}


