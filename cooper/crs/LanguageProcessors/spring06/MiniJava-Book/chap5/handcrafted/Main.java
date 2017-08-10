import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Program root = new MiniJavaParser(System.in).Goal();
         // System.out.println("Program parsed successfully");
	BuildSymbolTableVisitor v1 = new BuildSymbolTableVisitor();
        root.accept(v1);
 
	root.accept(new TypeCheckVisitor(v1.getSymTab()));
         // root.accept(new PrettyPrintVisitor());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}

