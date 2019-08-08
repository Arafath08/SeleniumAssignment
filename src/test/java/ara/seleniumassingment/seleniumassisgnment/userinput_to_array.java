package ara.seleniumassingment.seleniumassisgnment;

import java.util.Scanner;

public class userinput_to_array {
	//
	
	public static void main(String[] args) throws Exception {
	    Scanner s = new Scanner(System.in);
	    String[] array = new String[3];//static array
	    
	    System.out.println("Please enter 3 names to sort:");

	    for (int i = 0; i < array.length; i++) {
	        array[i] = s.nextLine();//nextLine()
	        
	    }

	    //Just to test
	    //System.out.println(array[0]);
	    for (int i = 0; i < array.length; i++) {
	    System.out.println(array[i]);
	    }
	   }
		/*Scanner ob = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String text =ob.next();
		String text1 =ob.nextLine();
		 System.out.println(text);
		 System.out.println(text1);*/
}

