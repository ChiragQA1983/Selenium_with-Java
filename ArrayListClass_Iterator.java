package dropdown;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.Get;
public class ArrayListClass_Iterator {

	public static void main(String[] args) {
		
		//add items to ArrayList
		ArrayList al=new ArrayList();
		al.add(10);
		al.add("CRB");
		al.add(true);
		//System.out.println(al.size());
		//System.out.println(al);
		
		//Remove item from the ArrayList
		
		//al.remove(0);
		//System.out.println(al);
		
		//Array List Can Store Duplicate Items Also  , Set will not accept duplicate value but Array List will accept duplicate value also
		//al.add("CRB");
		//al.add(true);
		//al.add("Test");
		//al.add(100);
		//System.out.println(al);
		
		// Using get we can Fetch the value from ArrayList as below (al.get(index number)); 
		
		//System.out.println(al.get(0));
		
		// We can use forloop for print the Arraylist as below
		//for(int i=0; i<al.size();i++)
		//{
			//System.out.println(al.get(i));
	//}
		/*for(Object obj:al) // <- This is foreach loop which is more simple than for loop
						   // We took Object because al is one kind of object 
		{
			System.out.println(obj);
		}*/
-----------------------------------------------------------------------------
    // We can also use Iterator as below to print the value 		
	Iterator itr=al.iterator();
	while (itr.hasNext())
	{
		System.out.println(itr.next());  
	}
		
		
}
}