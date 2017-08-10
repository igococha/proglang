/*
 * Class Interpreter: implements straightline PL interpreter
 *                    and related methods
 */

import java.io.*;
import java.lang.Math;

class Interpreter {

  public static void main(String args[])  {
      // Parser takes input from standard input (keyword)
      Parser parser = new Parser(System.in);
      Stm stm;
      BufferedReader prompt = 
	    new BufferedReader(new InputStreamReader(System.in));
      ByteArrayInputStream prog=null;
      System.out.println("Interpreter of one-line programs.");
      System.out.println("End input with <Enter>."+
                            " Terminate interpreter with empty program.");
      // Interpreter loop
      while (true) {
	    stm=null;
	    System.out.print("Enter Program > ");
	    System.out.flush();
	    try {
		prog = new ByteArrayInputStream(prompt.readLine().getBytes());
	    } catch (IOException e) {
		System.out.println("IO error while reading line");
		break;
	    }
	    Parser.ReInit(prog);
	    try { 
		// ****** Input/Output **************
		stm = parser.one_line();
		if (stm==null)
		    break;
		else {
		    System.out.println("Output = ");
		    Interpreter.interp(stm);
		}
	    } catch (ParseException e) {
		System.out.println("Parse error: "+e.getMessage());
		System.out.flush(); 
	    } catch (TokenMgrError e) {
		System.out.println("Parse error: "+e.getMessage());
		System.out.flush(); 
	    }
	}
    }

    
    static void interp(Stm s)  { 
	try {
	    s.interp(new Table()); return; 
	} catch (TableLookupException e) {
	    System.out.println(e.message);
	}
	return;
    }


}