package arrays;

import java.util.Scanner;

public class SubArraySort {

	static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] input = InputClass.getIntArrayFromString(scn.nextLine());
		SubArraySort obj = new SubArraySort();
		int output = obj.findLengthOfShortestSubarray(input);
		System.out.println(output);
	}

	/**
	 * Example 1:
	 * 
	 * Input: arr = [1,2,3,10,4,2,3,5] Output: 3 Explanation: The shortest subarray
	 * we can remove is [10,4,2] of length 3. The remaining elements after that will
	 * be [1,2,3,3,5] which are sorted. Another correct solution is to remove the
	 * subarray [3,10,4].
	 * 
	 * @param arr
	 * @return
	 */
	public int findLengthOfShortestSubarray(int[] arr) {

		int n = arr.length;
		int lo = -1;
		int hi = -1;
		int i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				lo = i;
				break;
			}
		}
		for (i = n - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				hi = i;
				break;
			}
		}

		if (lo == -1 || hi == -1) {
			return 0;
		}

		int maxlen = 0;
		i = lo;
		int j = n - 1;

		while (i >= 0 && j >= hi) {
			if (arr[i] > arr[j]) {
				maxlen = Math.max(maxlen, (i + 1) + (n - 1 - j));
				i--;
			} else {
				maxlen = Math.max(maxlen, (i + 1) + (n - j));
				j--;
			}
		}

		while (j >= hi) {
			maxlen = Math.max(maxlen, (n - j));
			j--;
		}
		while (i >= 0) {
			maxlen = Math.max(maxlen, (i + 1));
			i--;
		}

		return n - maxlen;

	}

	public int solve2(int[] arr) {
		int n = arr.length;
		int ei = n - 1;
		while (ei > 0 && arr[ei] >= arr[ei - 1]) {
			ei--;
		}
		int si = 0;
		int maxlen = (n - ei);
		while (si < ei && (si == 0 || arr[si] >= arr[si - 1]) && ei < n) {
			while (ei < n && arr[si] > arr[ei]) {
				ei++;
			}
			maxlen = Math.max(maxlen, (n - ei) + (si + 1));
			si++;
		}
		return n - maxlen;
	}

}
