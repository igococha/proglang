class Main {
  public static void main(String args[]) throws ParseException {
    Exp parser = new Exp(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      parser.S();
      System.out.println("Expression parser - parse successful");
    } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
