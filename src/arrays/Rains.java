package arrays;

import java.util.Scanner;

public class Rains {

	static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] height = InputClass.getIntArrayFromString(scn.nextLine());
		Rains r = new Rains();
//		System.out.println(r.trap1(height));
		System.out.println(r.trap3(height));
	}

	public int trap1(int[] height) {
		int n = height.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		int l = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			l = Math.max(height[i], l);
			leftMax[i] = l;
		}

		int r = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			r = Math.max(height[i], r);
			rightMax[i] = r;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return ans;
	}

	public int trap2(int[] height) {
		int n = height.length;
		int[] l = new int[n];
		int lmx = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			lmx = Math.max(lmx, height[i]);
			l[i] = lmx;
		}
		int output = 0;
		int rmx = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			rmx = Math.max(rmx, height[i]);
			output += Math.min(rmx, l[i]) - height[i];
		}
		return output;
	}

	/**
	 * @USING_TWO_POINTERS_APPROACH
	 * @param height
	 * @return
	 */
	public int trap3(int[] height) {

		int lmx = 0;
		int rmx = 0;

		int l = 0;
		int r = height.length - 1;

		int ans = 0;

		while (l < r) {
			if (height[l] < height[r]) {
				if (height[l] >= lmx) {
					lmx = height[l];
				} else {
					ans += lmx - height[l];
				}
				l++;
			} else {
				if (height[r] >= rmx) {
					rmx = height[r];
				} else {
					ans += rmx - height[r];
				}
				r--;
			}
		}

		return ans;

	}

}
