package Day6_JavaRecursive;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Factorial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the factorial number : ");
		int number = Integer.parseInt(bReader.readLine());
		System.out.println("The answer of "+number+"!" +" = "+factorial(number));
		
	}
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1){
			return 1;
		}
		else {
			return n * factorial(n-1);
			
		}
 
	}

}
