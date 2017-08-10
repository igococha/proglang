import java.util.Stack;


public class StackMachine {
    private enum Operator { PLUS, MINUS, MULT, DIV };
    public StackMachine() { stack = new Stack(); }
    public void pushInteger(int n) {
	stack.push(n);
    }
    public void clearStack() { stack.clear(); }
    public boolean isEmptyStack() { return stack.empty(); }
    public int popInteger() throws StackMachineException { 
	if (isEmptyStack())
	    throw new StackMachineException("Can't pop element from stack - stack empty");
	else
	    return ((Number)stack.pop()).intValue(); 
    }
    public void plus() throws StackMachineException 
    { applyOperator(Operator.PLUS); }
    public void subtract() throws StackMachineException 
    { applyOperator(Operator.MINUS); }
    public void multiply() throws StackMachineException 
    { applyOperator(Operator.MULT); }
    public void divide() throws StackMachineException
    { applyOperator(Operator.DIV);  }
    private void applyOperator(Operator op) throws StackMachineException {
    	int op1, op2, res;
	if (stack.size() < 2)
	    throw new StackMachineException("Operator("+op+") needs two operands on the stack");
	op1 = popInteger();
	op2 = popInteger();
	try {
	    switch (op) {
	    case PLUS: res = op1+op2; break;
	    case MINUS: res = op2-op1; break;  // careful with op order
	    case MULT: res = op1*op2; break;
	    case DIV: res = op2/op1; break;  // careful with op order
	    default: res=0;
	    }
	} catch (ArithmeticException e) {
	    throw new StackMachineException("Arithmetic exception while applying operator ("+op+").\nError: "+e.getMessage());
	}
	stack.push(res);
    }

    private Stack stack;

}