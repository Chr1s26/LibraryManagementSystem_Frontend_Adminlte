package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number : ");
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < number ; i++) {
			System.out.println("The fibonnaci sequence is "+fibonacci(i));
		}
		

	}
	
	public static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1 || n == 2 ) {
			return 1;
		}
		else {
			return fibonacci(n-2)+fibonacci(n-1);
		}
	}

}

