package main;

import java.util.HashMap;
import java.util.Map;


public class Variable {

	private Map<String,String> variable_map;
	
	/**Constructor that initializes the Map in the variable class.
	*/
	public Variable() {
		variable_map = new HashMap<String,String>();
	}
	
	/**Gets the variable Map. 
	 * @return Variable Map that contains all the variable declarations made.
 	*/
	public Map<String, String> getVariable_map() {
		return variable_map;
	}
		
	/**Takes the whole 'let...' line and stores the variable with its associated value in HashMap.
 	* 
 	* @param prefix Prefix to be removed.
 	* @param papi String that will get prefix removed.
 	* @return String that without prefix
 	*/
	protected static String remover(String prefix,String papi){
		
		int index = papi.indexOf(prefix);
		if (index == -1)
			throw new IllegalArgumentException("Your prefix doesn't exist in the string");
		
		String result = papi.substring(index+prefix.length(), papi.length());
		return result.trim();
	}
	
	
	/**Takes the whole 'let...' line and stores the variable with its associated value in HashMap.
 	* 
 	* @param let_line Variable declaration expression
 	* @param fs Function Store
 	*/
	public void store_var_line(String let_line, FunctionStore fs){
				
		String expr = remover("let", let_line);
		
		if(!Character.isLetter(expr.charAt(0))) 
			throw new IllegalArgumentException ("Can't start the name of a variable with a non-alphabetic character.");
		
		if (this.expr_check(expr,"=") == -2) {
			int index = expr.indexOf('=') + 1;
			String s = expr.substring(index).trim().trim();
			String r = expr.substring(0,index - 1).trim();
			variable_map.put(r, s);
		}
		
		if (this.expr_check(expr,"=") == 0) {
			int index = expr.indexOf('=') + 1;
			String s = expr.substring(index).trim().trim();
			String r = expr.substring(0,index - 1).trim();
			PrefixCalculator a = new PrefixCalculator();
			s = a.calculate(s, fs, variable_map, a );
			variable_map.put(r, s);
		}
		
		
	}
	
		
	/**This functions takes care of doing any expressions that involve operators, 
	* and evaluates it. 
 	* 
 	* @param var_decla Variable Declaration
 	* @param deli Expression
 	* @return Returns 0 if expression is operator, 1 if let, -1 def, -2 variable and number
 	*/
	protected Integer expr_check(String var_decla, String deli){
		
		int index = var_decla.indexOf(deli.trim()) + deli.length() + 1 ;
		String s = var_decla.substring(index).trim();
		
		if (s.startsWith("+") || s.startsWith("-") || s.startsWith("*") 
				|| s.startsWith("/") || s.startsWith("%"))
			return 0;
			
		else if (s.startsWith("let"))
			//h.store(s)-- but s is a string so first get var name and then value, then store
				return 1;
		
		else if (s.startsWith("def"))
				return -1;
			
			//else just store the variable, i guess... lol
			return -2;
	}

	
}
