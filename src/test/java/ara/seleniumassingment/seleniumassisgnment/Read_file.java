package ara.seleniumassingment.seleniumassisgnment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read_file {

	//Write a Java program to store text file content line by line into an array.
	 public static void main(String a[]){
	        StringBuilder sb = new StringBuilder();
	        String strLine = "";
	        System.out.println(strLine);//print empty
	        List<String> list = new ArrayList<String>();
	        try {
	             BufferedReader br = new BufferedReader(new FileReader("C:\\SELENIUM\\readfile\\example.txt"));
	              while (strLine != null)
	               {
	                strLine = br.readLine();
	                System.out.println(strLine);
	                sb.append(strLine);
	                sb.append(System.lineSeparator());
	                strLine = br.readLine();
	                if (strLine==null)
	                   break;
	                list.add(strLine);
	            }
	         System.out.println(Arrays.toString(list.toArray()));
	             br.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }
	     }
}
