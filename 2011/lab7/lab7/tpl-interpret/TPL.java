
class TPL {

  public static void main(String args[]) {
    TPLParser parser;
    if (args.length == 1) {
      System.out.println("TPL Interpreter Version 0.1:  Reading from file " + args[0] + " . . .");
      try {
        parser = new TPLParser(new java.io.FileInputStream(args[0]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("TPL Interpreter Version 0.1:  File " + args[0] + " not found.");
        return;
      }
    } else {
      System.out.println("TPL Interpreter Version 0.1:  Usage :");
      System.out.println("         java TPL inputfile");
      return;
    }
    try {
      parser.CompilationUnit();
      ((SimpleNode)parser.jjtree.rootNode()).dump("");	/* Added by DB */
      parser.jjtree.rootNode().identification();
      parser.jjtree.rootNode().typecheck();
      parser.jjtree.rootNode().interpret();
    } catch (ParseException e) {
      System.out.println("TPL Interpreter Version 0.1:  Encountered errors during parse.");
      e.printStackTrace();
    } catch (Exception e1) {
      System.out.println("TPL Interpreter Version 0.1:  Encountered errors during interpretation/tree building.");
      e1.printStackTrace();
    }
  }
}
