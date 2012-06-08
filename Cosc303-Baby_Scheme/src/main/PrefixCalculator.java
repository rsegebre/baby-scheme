package main;

import java.util.Map;
import java.util.Stack;
public class PrefixCalculator {
	private String temp = "", temp1;
	protected FunctionHandler fh = new FunctionHandler();
	
	/**It creates stack having the last element in the input at the top.
 	* 
 	* @param input String to be stored in stack
 	* @return Stack that contains the expression
 	*/
	private Stack<String> stacker(String input) {
		
    	input = input.trim();
		String[] info = input.split(" ");
    	Stack<String> operand = new Stack<String>();	
    	for (String s : info){
    		operand.push(s); 
    	}    	
    	return operand;
    }
	
	/**This functions executes any operation that yields an output. 
 	* @param input Expression to be evaluated
 	* @param funcs Functions stored
 	* @param pseudo Map storing the variables and their values
 	* @param p An instance of the current calculator being used
 	* @return String that contains the answer to the expression
 	*/
    protected String calculate(String input, FunctionStore funcs, Map<String, String> pseudo, PrefixCalculator p) {
    	int a, b;
    	char c;
    	FunctionHandler fh = new FunctionHandler();
     	Stack<String> operand = this.stacker(input);	
    	Stack<String> store = new Stack<String>();
    	
    	if (operand.size() == 1){
    		if(Character.isDigit(input.charAt(0)))
    			return operand.pop() + "";
    		else if(pseudo.containsKey(operand.peek()))
    			return pseudo.get(operand.peek());
    		else throw new IllegalArgumentException("Invalid input");
    	}
    		
    	while(true) {
    		if (operand.isEmpty() && store.size() == 1)
    			break;
    		else if (!(this.isOp(operand.peek())) && !(funcs.Funcmap.containsKey(operand.peek())))
    			store.push(operand.pop());
    			
    		else if (this.isOp(operand.peek())){
    			try{
    		  		a = (Character.isDigit(store.peek().charAt(0))) ? Integer.parseInt(store.pop()) : Integer.parseInt(pseudo.get(store.pop()));
    				b = (Character.isDigit(store.peek().charAt(0))) ? Integer.parseInt(store.pop()) : Integer.parseInt(pseudo.get(store.pop()));
    		   		c = operand.pop().charAt(0);
    		   		store.push(innercalc(c, a, b) + "");
    		   	} catch (NumberFormatException e){        		
    		    	System.out.println("The input provided is not a number");
    		   	}
    		}
    		else if (funcs.Funcmap.containsKey(operand.peek())){
    			temp = operand.pop();
    			temp1 = temp;
    			for(@SuppressWarnings("unused") Map.Entry<String, String> entry: funcs.Funcmap.get(temp1).parameters.entrySet()){
    				temp = temp + " " + store.pop();
    			}
    			store.push(fh.execute(temp.trim(), funcs, pseudo, p));
    		}
    	}
    	return store.pop() + "";
   	}
    
	/**This functions takes care of doing any expressions that involve operators, 
	* and evaluates it. 
 	* 
 	* @param a Integer
 	* @param b Integer
 	* @param c Operator
 	* @return Returns the output of a c b 
 	*/
    private int innercalc(char c, int a, int b) {
    	
    	switch (c) {
    	case '+':
    		return a+b;
    		
    	case '-':
    		return a-b;
    		
    	case '*':
    		return a*b;
    		
    	case '/':	
    		if (b == 0) {
    		    throw new IllegalArgumentException("Argument 'divisor' is 0");
    		}
    		return a/b;
    		
    	case '%':
    		return a%b;
    	
    	default:	
    		throw new IllegalArgumentException("Your Input format is wrong");
    	}
    }

    
	/**This function checks if it is an operator; returns false if Not.
 	* 
 	* @param num
 	* @return Returns True if input is an operator and False otherwise.
 	*/
    private boolean isOp(String num) {
		if (num.equals("-") || num.equals("+") || num.equals("/") ||
				num.equals("%") || num.equals("*"))
			return true;
		else return false;
	}
    
        
}


