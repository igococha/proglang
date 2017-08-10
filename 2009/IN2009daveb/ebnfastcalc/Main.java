import syntaxtree.*;

class Main {
  public static void main(String args[]) throws ParseException {
    Exp root;
    ExpParser parser = new ExpParser(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      root = parser.S();
      System.out.println("Answer is "+root.eval());
    } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
