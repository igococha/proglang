
public class Main {
   public static void main(String [] args) {
     try {
        // Read program to parse from standard input
        if (args.length == 0) 
            new MiniJavaParser(System.in).Goal();
        // Read program to parse from file i.e args[0]
        else 
            try { 
                new MiniJavaParser 
                  (new java.io.FileInputStream(args[0])).Goal();
            } catch ( java.io.FileNotFoundException e) {
                System.err.println("Unable to read file " + args[0] );
                return;
            }
     }
     catch (ParseException e) {
        System.out.println(e.toString());
     }
   }
}

