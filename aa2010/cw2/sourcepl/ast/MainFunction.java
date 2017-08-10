package ast;
import java.util.*;
import visitor.*;

public class MainFunction {
    public List<Stm> statements;
    public List<String> vars;
    public MainFunction(List<String> v,List<Stm> s) { statements=s; vars=v; }
    public int accept(Visitor v)  throws VisitorException
    { return v.visit(this); }
}



