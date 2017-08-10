class Main {
  public static void main(String args[]) throws ParseException {
     ExpParser parser = new ExpParser(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      parser.S();
     } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
