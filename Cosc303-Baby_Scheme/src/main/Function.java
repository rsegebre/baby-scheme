package main;



import java.util.Map;
import java.util.LinkedHashMap;

// one function only inner class

public class Function {

	protected String body;
	protected Map<String, String> parameters = new LinkedHashMap<String, String>();
	
	/** This constructor store the parameters of the function in a map, and the parameters
	 * in a map
 	* 
 	* @param var Takes a string array
 	* @param s String
 	*/
	protected Function(String[] var, String s){

		body = s;
		for(String s1 : var){
			parameters.put(s1, "");
		}
	}



}


