package practice.linearRecurrencesAndMatrixExponentiation;

import java.util.Scanner;

public class Exponent {

	static Scanner scn = new Scanner(System.in);
	static long MOD = 1_000_000_007;

	/**
	 * @param a
	 * @param b
	 * @return a ^ b
	 */
	public static int calculateExponent(int a, int b) {
		int res = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				res *= a;
			}
			a *= a;
			b /= 2; // or b >>= 1;
		}
		return res;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return a ^ b
	 * 
	 * here we are using a MODULO (a prime number in our range)
	 * so that we can keep the number in our range...
	 */
	public static long exponent(int a, int b) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				res *= a;
				res %= MOD;
			}
			a *= a;
			a %= MOD;
			b /= 2; // or b >>= 1;
		}
		return res;	
	}

	public static void main(String[] args) {
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(calculateExponent(a, b));
	}

}
