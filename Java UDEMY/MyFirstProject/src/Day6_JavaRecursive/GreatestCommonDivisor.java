package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the first number : ");
		int number1 = Integer.parseInt(br.readLine());
		System.out.print("Enter the second number :");
		int number2 = Integer.parseInt(br.readLine());
		System.out.println(gcd(number1, number2));
		
	}
	public static int gcd(int a,int b) {
		if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
	}

}
