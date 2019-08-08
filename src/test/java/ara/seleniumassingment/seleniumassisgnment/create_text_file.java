package ara.seleniumassingment.seleniumassisgnment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class create_text_file {
	
	 public static void main(String[] args) throws IOException 
	    { 
	        // Input string with repeating chars 
	       /* String s = "geeks for geeks"; 
	        System.out.println(unique(s));*/
	        
      Scanner ob =new Scanner(System.in);
     System.out.println("Enter a string:");
	        String text =ob.next();
	        
	      
	       
	        	 System.out.println(textfile(text));
	         
	    }
	public static String textfile(String text) throws IOException {
        //String text = "Hello world";
        BufferedWriter output = null;
        try {
            File file = new File("C:\\SELENIUM\\readfile\\example.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
            System.out.println(output);
          }
        }
		return text;
    }
}
