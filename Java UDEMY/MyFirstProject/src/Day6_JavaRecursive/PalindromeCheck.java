package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeCheck {

    public static void main(String[] args) throws IOException {
    	BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string : ");
        String str = bReader.readLine();
        boolean isPalindrome = isPalindrome(str);
        System.out.println(isPalindrome);  

       
    }

    public static boolean isPalindrome(String str) {
       
        if (str.length() <= 1) {
            return true;
        }

      
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        
        return isPalindrome(str.substring(1, str.length() - 1));
    }
}

