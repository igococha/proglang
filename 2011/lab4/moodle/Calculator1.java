class Calculator1 {
  public static void main(String args[]) throws ParseException {
    Exp1 parser = new Exp1(System.in);
    System.out.println("Type in an expression on a single line.");
    parser.S();
    System.out.println("Expression parser - parse successful");
  }
}
