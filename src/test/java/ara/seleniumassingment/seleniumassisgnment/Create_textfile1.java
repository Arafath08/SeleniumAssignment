package ara.seleniumassingment.seleniumassisgnment;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Create_textfile1 {
	
	public static void main(String[]args) {
   	 Scanner ob =new Scanner(System.in);
   	String[] array = new String[1];
        System.out.println("Enter a string:");
   	       // String text =ob.next();
   	     for (int i = 0; i < array.length; i++) {
 	        array[i] = ob.nextLine();
 	       String temp = array[i];
 	        
 	    }
   	  for (int i = 0; i < array.length; i++) { 
   	        String temp =array[i] ;
   	     System.out.println(writing(temp));
   	      }
   	Date d =new Date();
		
	}
	public static String writing(String temp) {
        try {
        	Date date = new Date();  
 	       //Specifying the format of the date using SimpleDateFormat
 	       SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
 	       //Formatting the date to the specified format
 	       String dateString = sdf.format(date);  
 	       System.out.println(dateString); 
 	      
			
			//Whatever the file path is.
            File statText = new File("C:\\SELENIUM\\readfile\\example"+dateString+".txt");
            
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write(temp); 
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
        return temp;
    }

    
}
