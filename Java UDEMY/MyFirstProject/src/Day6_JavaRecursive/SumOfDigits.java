package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Enter the number : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		System.out.println(sumofDigit(number));
		
	}
	public static int sumofDigit(int n) {
		n = Math.abs(n);
		if (n < 10) {
			return n;
		}
		int  remainder = n % 10;
		int remainingNumber = n / 10;
		return remainder + sumofDigit(remainingNumber);
	}

}
