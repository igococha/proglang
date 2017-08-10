import java.lang.Math.*;

class interp {

  public static void main(String args[]) throws java.io.IOException {
    // System.out.println(maxargs(prog.prog));   // UNCOMMENT THIS WHEN 
    interp(prog.prog);                           // maxargs() IS WORKING!
  }

  static void interp(Stm s) {
    Table t = interpStm (s, new Table ("", 0, null));
  }

  static int length (ExpList e) {
    if (e instanceof PairExpList)
      return (1 + length(((PairExpList) e).tail));
    else if (e instanceof LastExpList)
      return 1;
    else {
      System.out.println ("length(ExpList): unrecognised ExpList");
      return 0;
    }
  }

  static Table interpStm (Stm s, Table t) {
    if (s instanceof PrintStm)
      return interpPrintedExps (((PrintStm) s).exps, t);
    else if (s instanceof AssignStm) { /* remember as.exp might have Stms! */
      AssignStm as = (AssignStm) s;
      IntAndTable it  = interpExp (as.exp, t);
      return update (it.t, as.id, it.i);
    }
    else if (s instanceof CompoundStm) {
      CompoundStm cs = (CompoundStm) s;
      return interpStm (cs.stm2, interpStm (cs.stm1, t));
    }
    else {
      System.out.println ("error in interpStm");
      return t;
    }
  }

  static Table interpPrintedExps (ExpList e, Table t) {
    if (e instanceof PairExpList) {
      PairExpList pe = (PairExpList) e;
      IntAndTable it = interpExp (pe.head, t);
      System.out.print (it.i);
      System.out.print (" ");
      return interpPrintedExps (pe.tail, it.t);
    }
    else if (e instanceof LastExpList) {
      IntAndTable it = interpExp (((LastExpList) e).head, t);
      System.out.println (it.i);
      return it.t;
    }
    else {
      System.out.println ("error in interpPrintedExps");
      return t;
    }
  }

  static IntAndTable interpExp (Exp e, Table t) {
    if (e instanceof IdExp)
      return new IntAndTable (lookup (t, ((IdExp) e).id), t);
    else if (e instanceof NumExp)
      return new IntAndTable (((NumExp) e).num, t);
    else if (e instanceof OpExp) {
      OpExp oe = (OpExp) e;
      IntAndTable it1 = interpExp (oe.left, t);
      IntAndTable it2 = interpExp (oe.right, it1.t);
      if (oe.oper == OpExp.Plus)
        return new IntAndTable (it1.i+it2.i, it2.t);
      else if (oe.oper == OpExp.Minus)
        return new IntAndTable (it1.i-it2.i, it2.t);
      else if (oe.oper == OpExp.Times)
        return new IntAndTable (it1.i*it2.i, it2.t);
      else if (oe.oper == OpExp.Div)
        return new IntAndTable (it1.i/it2.i, it2.t);
      else 
        throw new Error ("interpExp: oper not recognised");
    }
    else if (e instanceof EseqExp)
      return interpExp (((EseqExp) e).exp, interpStm (((EseqExp) e).stm, t));
    else
      throw new Error ("interExp: exp not recognised");
  }

  static Table update (Table t, String id, int i) {
    return new Table (id, i, t);
  }

  static int lookup (Table t, String key) {
    if (key == t.id) 
      return t.value;
    else
      return lookup (t.tail, key);
  }

}

