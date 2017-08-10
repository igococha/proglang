import syntaxtree.*;
import visitor.*;

// modified by DB Feb 04 to read from filename if one on command line.

public class Main {
   public static void main(String [] args) {
      Program root;
      try {
         // Read program to be parsed from standard input
         if (args.length == 0)
             root = new MiniJavaParser(System.in).Goal();
         else
             try {
                root = new MiniJavaParser 
                  (new java.io.FileInputStream(args[0])).Goal();
             } catch ( java.io.FileNotFoundException e) {
                System.err.println("Unable to read file " + args[0] );
                return;
             }
         root.accept(new DBPrettyVisitor());
         BuildSymbolTableVisitor stvisit = new BuildSymbolTableVisitor();
         root.accept(stvisit);
         root.accept(new TypeCheckVisitor(stvisit.getSymTab()));
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}

