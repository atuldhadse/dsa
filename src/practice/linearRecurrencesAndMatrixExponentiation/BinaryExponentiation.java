package practice.linearRecurrencesAndMatrixExponentiation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinaryExponentiation {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(getPower(a, b));
		
		int[] arr = {1, 2, 3, 4};
		List<Integer> list = Arrays.stream(arr).boxed().toList();
//		Collections
		
		
		
		
	}

	public static long getPower(int a, int b) {
		long ans = 1l;
		while (b > 0) {
			if ((b & 1) == 1) {
				ans *= a;
			}
			a *= a;
			b /= 2;
		}
		return ans;
	}

}
