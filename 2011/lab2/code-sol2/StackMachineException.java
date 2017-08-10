
public class StackMachineException extends Exception {
    public StackMachineException() { }
    public StackMachineException(String msg) { super(msg); }
    public String toString() { return "Stack Machine error: "+getMessage(); }
}