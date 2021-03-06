abstract class Stm { 
    void interp(Table t) throws TableLookupException { return;}
    int maxargs() { return 0; }
}

class CompoundStm extends Stm {
    Stm stm1, stm2;
    CompoundStm(Stm s1, Stm s2) {stm1=s1; stm2=s2;}
    void interp(Table t) throws TableLookupException { return; }
    int maxargs() { return 0; }
}

class AssignStm extends Stm {
    String id; Exp exp;
    AssignStm(String i, Exp e) {id=i; exp=e;}
    void interp(Table t) throws TableLookupException { return; }
    int maxargs() { return 0; }
}

class PrintStm extends Stm {
    ExpList exps;
    PrintStm(ExpList e) {exps=e;}
    void interp(Table t) throws TableLookupException { return; }
    int maxargs() { return 0; }
}

abstract class Exp {
    int interp(Table t) throws TableLookupException { return 0; }
    int maxargs() { return 0; }
}

class IdExp extends Exp {
    String id;
    IdExp(String i) {id=i;}
    int interp(Table t) throws TableLookupException {
	return 0;
    }
    int maxargs() { return 0; }
}

class NumExp extends Exp {
    int num;
    NumExp(int n) {num=n;}
    int interp(Table t) { return 0; }
    int maxargs() { return 0; }
}

class OpExp extends Exp {
    Exp left, right; int oper;
    final static int Plus=1,Minus=2,Times=3,Div=4;
    OpExp(Exp l, int o, Exp r) {left=l; oper=o; right=r;}
    int interp(Table t) throws TableLookupException { return 0;  }
    int maxargs() { return 0; }
}

class EseqExp extends Exp {
    Stm stm; Exp exp;
    EseqExp(Stm s, Exp e) {stm=s; exp=e;}
    int interp(Table t)  throws TableLookupException {
	return 0; }
    int maxargs() { return 0; }
}

abstract class ExpList {
    void interp(Table t) throws TableLookupException{ return; }
    int maxargs() { return 0; }
    public int length() { return 0; }
}

class PairExpList extends ExpList {
    Exp head; ExpList tail;
    public PairExpList(Exp h, ExpList t) {head=h; tail=t;}
    void interp(Table t) throws TableLookupException {
	return;
    }
    int maxargs() { return 0; }
    public int length() { // recursive implementation
	return 1+tail.length(); }
}

class LastExpList extends ExpList {
    Exp head;
    public LastExpList(Exp h) {head=h;}
    void interp(Table t) throws TableLookupException {	return; }
    int maxargs() { return 0; }
    public int length() { return 1; }
}
