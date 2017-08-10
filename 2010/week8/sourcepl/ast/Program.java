package ast;

import visitor.*;

public class Program {
    public MainFunction mainf;
    public Program(MainFunction m) { mainf=m;}
    public int accept(Visitor v) throws VisitorException
    { return v.visit(this); }
}





