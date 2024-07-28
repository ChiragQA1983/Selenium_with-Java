package dropdown;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.Get;
public class ArrayListWithDatatypeDeclaration {

	public static void main(String[] args) {
		
	//add items to ArrayList
	ArrayList<Integer> al=new ArrayList<Integer>();  // According to data type declaration value should be stored under array object
	al.add(10); // If ArrayList<String> than only String value should be store in array object
	al.add(20);
	al.add(30);
		
    // We can also use Iterator as below to print the value 		
	Iterator itr=al.iterator();
	while (itr.hasNext())
	{
		System.out.println(itr.next());  
	}
		
		
}
}