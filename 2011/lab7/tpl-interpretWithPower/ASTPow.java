/* Generated By:JJTree: Do not edit this line. ASTPow.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTPow extends SimpleNode {
  public ASTPow(int id) {
    super(id);
  }

  public ASTPow(TPLParser p, int id) {
    super(p, id);
  }


 /* Added by DB to perform identification and type checking. */

  public void identification () {
    jjtGetChild(0).identification();
    jjtGetChild(1).identification();
  }

  public void typecheck () {
    jjtGetChild(0).typecheck();
    jjtGetChild(1).typecheck();
    if (!(jjtGetChild(0).GetNodeType() == TPLTypes.intType &&
          jjtGetChild(1).GetNodeType() == TPLTypes.intType))
       System.out.println("TPL Typechecker: mult of non-ints.");
    NodeType = TPLTypes.intType;
  }

  /* Added by DB to perform interpreting. */

  public void interpret () {
    int left, right;
    jjtGetChild(0).interpret();
    jjtGetChild(1).interpret();

    right = ((Integer)stack.pop()).intValue();
    left = ((Integer)stack.pop()).intValue();

    stack.push(new Integer((int)Math.pow(left,right)));
  }

}
/* JavaCC - OriginalChecksum=2b2715a0b4701930b737baf39ca4d632 (do not edit this line) */
