package Day6_JavaRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PowerOfaNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the base : ");
		double base = Double.parseDouble(br.readLine());
		System.out.print("Enter the exponent : ");
		double exponent = Double.parseDouble(br.readLine());
		System.out.println(power(base, exponent));

	}
	public static double power (double base, double exponent) {
		if (exponent == 0) {
			return 1;
		}
		else if (exponent == 1) {
			return base;
		}
		else {
			return base * power(base, exponent-1);
		}
	}

}
