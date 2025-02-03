package practice.linearRecurrencesAndMatrixExponentiation;

import java.util.Scanner;

public class LargeMultiplication {

	public static Scanner scn = new Scanner(System.in);
	public static long MOD = 1_000_000_000 + 7;
	
	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return (a * b) % c
	 * 
	 * 
	 * 
	 */
	public static long multiply(int a, int b, long c) {
		long res = 0;
		while (b > 0) {
			if ((b & 1) != 0) {
				res += a;
				res %= c;
			}
			a += a;
			a %= c;
			b /= 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int a = scn.nextInt();
		int b = scn.nextInt();
		
		System.out.println(multiply(a, b, MOD));
		
	}
	
}
