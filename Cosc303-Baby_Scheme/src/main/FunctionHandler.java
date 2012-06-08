package main;

import java.util.Map;

public class FunctionHandler {
	
	private String fname, fbody;
	private String[] arr1, arr2;
	
	
	/**This functions executes a function call for an already existing expression.
 	* 
 	* @param call The body of the function
 	* @param funcs Functions stored
 	* @param pseudo Map storing the variables and their values
 	* @param p An instance of the current calculator being used
 	* @return String that contains the answer to the expression
 	*/
	protected String execute(String call, FunctionStore funcs, Map<String, String> pseudo, PrefixCalculator p){
		int i = 0,a;
		call = call.trim();
		a = call.indexOf(" ");
		fname = call.substring(0, a);

		
		arr1 = call.substring(a+1, call.length()).split(" ");
		Function f1 = funcs.Funcmap.get(fname);
		
		for(String s: f1.parameters.keySet() ) {
			if (Character.isDigit(arr1[i].charAt(0)) ) {
				f1.parameters.put(s, arr1[i++]);
			}
			else f1.parameters.put(s, pseudo.get(arr1[i++]));
		}	
		fbody = f1.body.trim();
		arr2 = fbody.split(" ");

		for(String s: arr2){
			if(f1.parameters.containsKey(s)){
				fbody = fbody.replaceFirst(s, f1.parameters.get(s));
			}
			if(pseudo.containsKey(s)) {
				fbody = fbody.replaceFirst(s, pseudo.get(s));
			}
		} 
		return p.calculate(fbody, funcs, pseudo, p);
	}

}