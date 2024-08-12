package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNaturalNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the natural numbers");
		int number = Integer.parseInt(br.readLine());
		System.out.print("The sum of natural number is "+sumOfNaturalNumbers(number));
		
	}
	public static int sumOfNaturalNumbers(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sumOfNaturalNumbers(n-1);
	}
}