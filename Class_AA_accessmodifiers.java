package accessmodifiers;

public class Class_AA_accessmodifiers extends Class_A_AccessModifiers  {

	public static void main(String[] args) {
		
		Class_A_AccessModifiers ca=new Class_A_AccessModifiers(); 
	
		
		Class_AA_accessmodifiers cb=new Class_AA_accessmodifiers(); 
		
		cb.defaultMethod(); // <- here we are using another class property with same class object 
		
		// without declaring extends keyword we can't access property of Class_A_AccessModifiers with class Class_AA_accessmodifiers object declaration
		//but if we use extends key words like above then we can access the property of  Class_A_accessmodifiers
		// Observed above example closely
		
		
	}

}


//We can access from Class_A_AccessModifiers public variables and methods, protected variables and method as well default variales and method
// but we can access private variables and methods from class Class_A_AccessModifiers