package visitor;

import ast.*;

public interface Visitor {
  public int visit(Program n) throws VisitorException;
  public int visit(MainFunction n) throws VisitorException;
  public int visit(PrintStm n) throws VisitorException;
  public int visit(AssignStm n) throws VisitorException;
  public int visit(IfStm n) throws VisitorException;
  public int visit(WhileStm n) throws VisitorException;
  public int visit(IdExp n) throws VisitorException;
  public int visit(OpExp n) throws VisitorException;
  public int visit(CmpExp n) throws VisitorException;
  public int visit(BoolExp n) throws VisitorException;
  public int visit(IntLiteralExp n) throws VisitorException;
  public int visit(BoolLiteralExp n) throws VisitorException;
  public int visit(NotExp n) throws VisitorException;
}
