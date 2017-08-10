class ExceptionTest {

    public static void main(String[] args){
       System.out.println (new ET().doit());
    }
}

class ET {
    public int doit() { 
        boolean finished;
        int p;
       finished = false;
        do {
            try{
                p = this.processUserInput();
            } catch (VowelException x) {
                System.out.println(666);
            } catch (BlankException x) {
                System.out.println(777);
            } catch (ExitException x) {
                System.out.println(888);
                finished = true;
                System.out.println(0);   // finally clause not executed
            } finally {
                System.out.println(999);
            }
        
        } while (!finished);
        return(0);
    }

    public int processUserInput() {
    
    int i;
        BufferedReader kbd;
    
    try {
        kbd = new BufferedReader();
        if((line.length) < 1)
             i = 11;
        else
             i = Character.toUpperCase(i);
   } catch (IOException x) {
        System.out.println(9999);
   } finally {}
   
   if (this.isvowel(i))
        throw new VowelException();
   else
        throw new BlankException();
   return (999);
   }
}

class VowelException extends Exception {}
class BlankException extends Exception {}
class ExitException extends Exception {}
