/*
 * Class Main: Calls parser, pretty printer and interpreter for
 *             the Source PL
 */

import ast.*;
import visitor.*;

import java.io.*;

class Main {

  public static void main(String args[])  {
      Program root;
      try {
         // Read program to be parsed from standard input
         if (args.length == 0)
             root = new Parser(System.in).program();
         else
             try {
                root = new Parser 
                  (new java.io.FileInputStream(args[0])).program();
             } catch ( java.io.FileNotFoundException e) {
                System.err.println("Unable to read file " + args[0] );
                return;
             }
	 try {
	     root.accept(new PrinterVisitor());
	 } catch(VisitorException e) {
	     System.out.println("Error while printing: "+e.message);
	 }
	 	 try {
	    root.accept(new Interpreter());
	 } catch(VisitorException e) {
	     System.out.println("Runtime Error: "+e.message);
	 }
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
  }
}


