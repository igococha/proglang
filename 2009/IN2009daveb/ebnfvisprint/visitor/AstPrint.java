package visitor;

import syntaxtree.*;

public class AstPrint implements Visitor {
  String indent="";

  public int visit (PlusExp n) {
    indent=indent+"-";
    System.out.println(indent+"PlusExp");
    n.e1.accept(this); n.e2.accept(this);
    indent=indent.substring(1);
    return 0;
  }

  public int visit (MinusExp n) {
    indent=indent+"-";
    System.out.println(indent+"MinusExp");
    n.e1.accept(this);n.e2.accept(this);
    indent=indent.substring(1);
    return 0;
  }

  public int visit (TimesExp n) {
    indent=indent+"-";
    System.out.println(indent+"TimesExp");
    n.e1.accept(this);n.e2.accept(this);
    indent=indent.substring(1);
    return 0;
  }

  public int visit (DivideExp n) {
    indent=indent+"-";
    System.out.println(indent+"DivideExp");
    n.e1.accept(this);n.e2.accept(this);
    indent=indent.substring(1);
    return 0;
  }

  public int visit (NumExp n) {
    indent=indent+"-";
    System.out.println(indent+n.f0);
    indent=indent.substring(1);
    return 0;
  }
}
