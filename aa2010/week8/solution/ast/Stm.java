package ast;
import visitor.*;

public abstract class Stm { 
    public abstract int accept(Visitor v)  throws VisitorException;
}




