package Tree;import Temp.Temp;import java.util.LinkedList;public class BINOP extends Exp {    public int binop;    public Exp left, right;    public BINOP(int b, Exp l, Exp r) {	binop=b; left=l; right=r; }    public final static	int PLUS=0, MINUS=1, MUL=2, DIV=3, AND=4, OR=5,	LSHIFT=6,RSHIFT=7,ARSHIFT=8,XOR=9;    public LinkedList<Exp> kids() {	LinkedList<Exp> kids = new LinkedList<Exp>();	kids.addFirst(left);	kids.addLast(right);	return kids;    }    public Exp build(LinkedList<Exp> kids) {	return new BINOP(binop, kids.getFirst(), kids.getLast());    }    public void accept(IntVisitor v, int d) { v.visit(this, d); }    public Temp accept(CodeVisitor v) { return v.visit(this); }    public <R> R accept(ResultVisitor<R> v) { return v.visit(this); }}