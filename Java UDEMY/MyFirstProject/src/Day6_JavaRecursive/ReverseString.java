package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string : ");
		String string = bufferedReader.readLine();
		System.out.println(reverseString(string));
		
	}
	public static String reverseString(String s) {
	     if (s.length() <= 1) {
	    	 return s;
	     }
	     int mid = s.length() / 2;
	     
	     String reverseRightString = reverseString(s.substring(mid));
	     String reverseLeftString = reverseString(s.substring(0,mid));
	     
	     return reverseRightString + reverseLeftString;
	     
 	}

}