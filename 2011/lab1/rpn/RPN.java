import java.io.*;
import java.lang.Integer;

public class RPN {
    public static void main(String [] args) {
	BufferedReader cin;
	String RPNexpression;
	boolean stop = false;
	Lexer lexer;
	StackMachine machine = new StackMachine();

	cin = new BufferedReader(new InputStreamReader(System.in)); 
	System.out.println("Reverse Polish Notation Calculator");
	System.out.println("Enter RPN expression after prompt and hit Enter");
	System.out.println("Or just hit Enter to Exit");
	while (!stop) {
	    System.out.print("Enter Expression > ");
	    try {
		RPNexpression = cin.readLine();
	    } catch (java.io.IOException e) {
		System.out.println("Error while reading from standard input");
		stop = true;
		continue;
	    }
	    if (RPNexpression.trim().length()==0) {
		stop = true;
	    } else {
		calculate(machine, RPNexpression.trim());
	    }
	}
	System.out.println("Quitting calculator...");
    }

    private static void calculate(StackMachine machine, String e) {
	Lexer lexer = new Lexer(e);
	Token token;
	machine.clearStack(); // Clear contents of stack 
	while (lexer.hasNextToken()) {
	    try {
		token = lexer.getNextToken();
		switch (token.kind) {
		case INTEGER: 
		    machine.pushInteger(Integer.parseInt(token.image));
		    break;
		case PLUS: machine.plus(); break;
		case MINUS: machine.subtract(); break;
		case MULT: machine.multiply(); break;
		case DIV: machine.divide(); break;
		}
	    } catch (LexerException le) {
		System.out.println("Lexer Error:");
		return;
	    }
	    catch (StackMachineException sme) {
		System.out.println(sme);
		return;
	    }
	}
	try {
	    System.out.println("Result: "+machine.popInteger());
	} catch (StackMachineException sme) {
	    System.out.println("Error while reading result\n"+sme);
	}

    }



}