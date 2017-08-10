import java.io.*;


    class Parseint {


	public static void main(String[] args) {
	    String input=null;
	    int decval=0;
	    BufferedReader br = 
		new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
		System.out.print("Enter hex:");
		try {
		    input = br.readLine();
		    		    
		} catch (IOException ioe) {
		    System.out.println("IO error trying to read input!");
		}

		try {
		  decval = parseHex(input);
		  System.out.println(decval);

		  decval = parseHex2(input);
		  System.out.println(decval);

  
		} catch (Exception e) {
		    System.out.println("Incorrect Hex");
		}

		
	    }
	}

	public static int parseHex(String hex) throws Exception {
	    int exp, valchar=0, val=0, l;
	    short base=16;
	    char ch; 
	    StringBuffer buf = new StringBuffer(hex);
	    l = buf.length();

	    exp = 1;
	    for(int i=l-1; i >= 0; i--) {
		ch=buf.charAt(i);
		if (ch >= '0' && ch <= '9')
		    valchar = ch-'0';
		else if (ch >= 'a' && ch <= 'f')
		    valchar = 10 + (ch-'a');
		else if (ch >= 'A' && ch <= 'F')
		    valchar = 10 + (ch-'A');
		else
		    throw new ParseIntException("Bad Char "+ch);
		val = val + valchar*exp;
		System.out.println(val);
		exp = exp*base;
	    }
	    return val;
	}

	public static int parseHex2(String hex) throws Exception {
	    int exp, valchar=0, val=0, l;
	    short base=16;
	    char ch; 
	    StringBuffer buf = new StringBuffer(hex);
	    l = buf.length();

	    exp = 1;
	    for(int i=0; i < l; i++) {
		ch=buf.charAt(i);
		if (ch >= '0' && ch <= '9')
		    valchar = ch-'0';
		else if (ch >= 'a' && ch <= 'f')
		    valchar = 10 + (ch-'a');
		else if (ch >= 'A' && ch <= 'F')
		    valchar = 10 + (ch-'A');
		else
		    throw new ParseIntException("Bad Char "+ch);
		val = val*base + valchar;
		System.out.println(val);
		exp = exp*base;
	    }
	    return val;
	}
    }

class ParseIntException extends Exception {
	ParseIntException(String msg) {
	    super(msg);
	}
    }


    
