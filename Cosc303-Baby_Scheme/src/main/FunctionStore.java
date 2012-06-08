package main;

import java.util.HashMap;
import java.util.Map;

public class FunctionStore {

	protected Map<String, Function> Funcmap = new HashMap<String, Function>();
	private String name, body;
	private String[] arr;
	private int a,b;
	/**This method stores a function declarations. 
 	* 
 	* @param f The body of the function
 	* @param var Map of variables stored
 	*/
	protected void FuncMaker(String f, Map<String, String> var){
		f = f.trim();
		a = f.indexOf(" ");
		name = f.substring(0, a);
		b = f.indexOf("=");
		arr = f.substring(a+1,b-1).split(" ");
		body = f.substring(b+2,f.length());	
		Funcmap.put(name, new Function(arr, body));	
	}
	
}
