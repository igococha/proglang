package ast;

import visitor.*;


public abstract class Exp {
    public abstract int accept(Visitor v) throws VisitorException;
}



