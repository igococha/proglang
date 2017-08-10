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
	    System.out.print("Enter Program: ");
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
		    // non OO version - comment out for part 2)
		    System.out.println("Maxargs = "+Interpreter.maxargs(stm));
		    // object oriented version - uncomment below for part 2)
		    // System.out.println("Maxargs = "+stm.maxargs());
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

    /* ***************************
       Maxargs implementation 1
       *************************** */

  static int maxargs(Stm s) {
      if (s instanceof PrintStm) {
	  return Math.max (maxargs (((PrintStm) s).exps), 
			   ((PrintStm) s).exps.length());
      } else if (s instanceof AssignStm) {
	  return maxargs (((AssignStm) s).exp);
      } else if (s instanceof CompoundStm) {
	  return Math.max (maxargs (((CompoundStm) s).stm1), 
			maxargs (((CompoundStm) s).stm2));
      } else {
	  System.out.println("maxargs(Stm): unrecognised Stm");
	  return 0;
      }
  }

    static int maxargs (ExpList e) {
	if (e instanceof PairExpList)
	    return Math.max(maxargs (((PairExpList) e).head),
			    maxargs (((PairExpList) e).tail));
	else if (e instanceof LastExpList)
	    return maxargs (((LastExpList) e).head);
	else 
	    System.out.println("maxargs(ExpList): unrecognised ExpList");
	return 0;
    }

    static int maxargs (Exp e) {
	if (e instanceof OpExp) {
	    return Math.max(maxargs (((OpExp) e).left),
			    maxargs (((OpExp) e).right));
	} else if (e instanceof EseqExp) {
	    return Math.max(maxargs (((EseqExp) e).stm),
			    maxargs (((EseqExp) e).exp));
	} else 
      /* it's an IdExp or a NumExp */
	    return 0;
    }


}