package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LongestMountain {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = Arrays.asList(scn.nextLine().split(",")).stream().map(Integer::parseInt).mapToInt(Integer::intValue)
				.toArray();
		LongestMountain obj = new LongestMountain();
		int output = obj.longestMountain(arr);
		System.out.println(output);
	}

	public int longestMountain(int[] arr) {
		int n = arr.length;
		if (n < 3) {
			return 0;
		}
		int longest = 0;
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				int j = i;
				while (j > 0 && arr[j] > arr[j - 1]) {
					j--;
				}
				while (i < n - 1 && arr[i] > arr[i + 1]) {
					i++;
				}
				longest = Math.max(longest, i - j + 1);
			}
		}
		return longest;
	}

}
