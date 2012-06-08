package main;

import java.util.Stack;

public class The_Scheminator {

	PrefixCalculator machina = new PrefixCalculator();
	/**Puts everything in a stack having the first statement at the top of the stack.
 	* 
 	* @param input Expression to put in stack
 	* @return Stack contained Expression
 	*/
	private Stack<String> stacky(String input) {
		input = input.trim();
		String[] info = input.split(" ");
    	Stack<String> operand = new Stack<String>();
    	for (int i = info.length - 1 ; i >= 0 ; i--){
    		operand.push(info[i]);
    		}    	
    	return operand;
    }
	
	/**This method classifies a given expression into parts and calls the appropriate method
	 * to take care of the entire baby_scheme expression. It puts the whole expression into a 
	 * stack and then analyzes part by part. If its a let it sends it to the variable class, if is
	 * a def it gets stored in FunctionStore, and any of the computations get done in the calculate method 
	 * in Prefix Calculator.
 	* 
 	* @param input Expression to put evaluate
 	* @return String that contains the answer to the expression
 	*/
	public String terminate(String input){
		Variable j = new Variable();
		Stack<String> mainStack = stacky(input);
		FunctionStore fs = new FunctionStore();
		PrefixCalculator h = new PrefixCalculator();
		while (!mainStack.isEmpty()) {
	
			if (mainStack.peek().equals("let")){	
				String a = mainStack.pop()+ " ";//get let
				a += mainStack.pop() + " ";//gets variable name
				a += mainStack.pop() + " ";//gets equals
				while (true) {
					if (mainStack.peek().equals("let")){
						throw new IllegalArgumentException("You can't do a let x = let...");
					}
					a+= mainStack.pop() + " ";
					if (mainStack.peek().equals("in")){
						mainStack.pop();//gets rid of in
						break;
					}
				}
				j.store_var_line(a, fs);
			
			
			}
			else if (mainStack.peek().equals("def")){
				mainStack.pop();//gets rid of def
				String b = "";
				while (true) {
					b += mainStack.pop() + " ";
					if (mainStack.peek().equals("in")){
						mainStack.pop();//gets rid of in
						break;
					}
				}
				fs.FuncMaker(b, j.getVariable_map());				
				//System.out.println("Function sent to maker 'b': " + b);		

			}
			
			else if (mainStack.peek().startsWith("+") || mainStack.peek().startsWith("-") || mainStack.peek().startsWith("*") 
					|| mainStack.peek().startsWith("/") || mainStack.peek().startsWith("%") || 
					fs.Funcmap.containsKey(mainStack.peek()) || j.getVariable_map().containsKey(mainStack.peek()) 
					|| Character.isDigit(mainStack.peek().charAt(0))) {
				
				String c = "";
				while (!mainStack.isEmpty()) {
					//System.out.println("c: " + c);
					 c += mainStack.pop() + " ";	
			}

				return h.calculate(c, fs, j.getVariable_map(), h);
				
			}
		}
	return "invalid input";
	}
}