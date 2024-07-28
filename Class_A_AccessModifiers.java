package accessmodifiers;

public class Class_A_AccessModifiers {

	public int publicVariable=1;
	int defaultVariable=2;
	protected int protectedVariable=3;
	private int privateVariable=4;
	
	public void publicMethod()
	{
		System.out.println("This is public method");
	}
	
	private void privateMethod()
	{
		System.out.println("This is private method");
	}
	
	void defaultMethod()
	{
		System.out.println("Default method is calling here");
	}
	
	protected void protectedMethod()
	{
		System.out.println("This is protectedmethod");
	}
	
	// we can access all the variables and method from main by creating class as below 
	
	public static void main(String[] args) {
	
		Class_A_AccessModifiers ca=new Class_A_AccessModifiers();  // <- this how we will declare the object
		ca.privateMethod();    //<- this how we will call the method and variables
		
		
	}

}
