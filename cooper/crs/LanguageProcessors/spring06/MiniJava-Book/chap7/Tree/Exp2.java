package Tree;import Temp.Temp;import Temp.Label;import java.util.LinkedList;public class EXP extends Stm {    public Exp exp;     public EXP(Exp e) { exp=e; }    public LinkedList<Exp> kids() {	LinkedList<Exp> kids = new LinkedList<Exp>();	kids.addFirst(exp);	return kids;    }    public Stm build(LinkedList<Exp> kids) { return new EXP(kids.getFirst()); }    public void accept(IntVisitor v, int d) { v.visit(this, d); }    public void accept(CodeVisitor v) { v.visit(this); }    public <R> R accept(ResultVisitor<R> v) { return v.visit(this); }}