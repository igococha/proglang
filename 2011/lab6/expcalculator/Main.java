class Main {
  public static void main(String args[]) throws ParseException {
     ExpParser parser = new ExpParser(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      parser.S();
      ((SimpleNode)parser.jjtree.rootNode()).dump("");
      int value = ((SimpleNode)parser.jjtree.rootNode()).evaluate();
      System.out.println("Result="+value);
      System.out.println("Counter="+SimpleNode.counter);
    } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
