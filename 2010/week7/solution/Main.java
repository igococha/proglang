import syntaxtree.*;
import visitor.*;

class Main {
  public static void main(String args[]) throws ParseException {
    Exp root;
    ExpParser parser = new ExpParser(System.in);
    try {
      System.out.println("Type in an expression on a single line.");
      root = parser.S();
      Calc calculator = new Calc();
      int value = root.accept(calculator);
      System.out.println("Answer is "+value);
      /* Add new code after this line */
      AstPrint printer =  new AstPrint();
      System.out.println("The expression is: ");
      root.accept(printer);
    } catch (ParseException e) {
      System.out.println("Expression parser - error in parse");
    }
  }
}
