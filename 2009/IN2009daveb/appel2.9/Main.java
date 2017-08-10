class Main {
  public static void main(String args[]) throws ParseException {
    System.out.println ("Type in tokens separated by white space");
    System.out.println ("Type EOF to end...EOF is Ctrl-D (Unix), Ctrl-Z (PC)");
    MyParser parser = new MyParser(System.in);
    parser.Start();
  }
}
