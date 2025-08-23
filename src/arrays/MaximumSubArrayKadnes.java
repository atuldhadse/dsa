package arrays;

import java.util.Scanner;

public class MaximumSubArrayKadnes {

	static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = InputClass.getIntArrayFromString(scn.nextLine());
		MaximumSubArrayKadnes obj = new MaximumSubArrayKadnes();
		System.out.println(obj.maxSubArray(arr));
	}

	public int maxSubArray(int[] nums) {

		int maxx = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (nums[i] > sum) {
				sum = nums[i];
			}
			maxx = Math.max(maxx, sum);
		}
		return maxx;

	}

}
