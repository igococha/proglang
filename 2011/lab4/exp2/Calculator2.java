class Calculator2 {
  public static void main(String args[]) throws ParseException {
    Exp2 parser = new Exp2(System.in);
    System.out.println("Type in an expression on a single line.");
    int result=parser.S();
    System.out.println("Result="+result);
  }
}
