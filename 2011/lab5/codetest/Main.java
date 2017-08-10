class Main {
  public static void main(String args[]) throws ParseException {
    int result;
    ExpParser parser = new ExpParser(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      result = parser.S();
      System.out.println("Answer is "+result);
    } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
