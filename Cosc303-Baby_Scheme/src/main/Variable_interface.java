package main;


public interface Variable_interface {

	//Stores the variable inside the hashMap, using the var_name, as the key
	//and the object value as the value.
	public void store_var(String var_name, Object value);
	
	
	//Checks if format of the variable is another expression
	public Boolean expr_check(String var_declaration);
	
	
	
}
