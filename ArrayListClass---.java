package dropdown;

import java.util.ArrayList;

import org.apache.commons.collections4.Get;
public class ArrayListClass {

	public static void main(String[] args) {
		
		//add items to ArrayList
		ArrayList al=new ArrayList();
		al.add(10);
		al.add("CRB");
		al.add(true);
		System.out.println(al.size());
		System.out.println(al);
		
		//Remove item from the ArrayList
		
		al.remove(0);
		System.out.println(al);
		
		//Array List Can Store Duplicate Items Also  , Set will not accept duplicate value but Array List will accept duplicate value also
		al.add("CRB");
		al.add(true);
		System.out.println(al);
		
		// Using get we can Fetch the value from ArrayList as below (al.get(index number)); 
		
		System.out.println(al.get(0));
		
	}

}
