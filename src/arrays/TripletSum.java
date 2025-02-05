package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TripletSum {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] nums = Arrays.asList(scn.nextLine().split(",")).stream().map(Integer::parseInt).toList().stream()
				.mapToInt(Integer::intValue).toArray();
		Arrays.sort(nums);
		for (int n : nums)
			System.out.print(n + " ");
		System.out.println();
		TripletSum t = new TripletSum();
		List<List<Integer>> output = t.helper(nums, 0);
		for (List<Integer> i : output) {
			for (Integer j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (List<Integer> pair : pairSum(nums, i + 1, nums.length - 1, target - nums[i])) {
				pair.add(0, nums[i]);
				output.add(pair);
			}
		}
		return output;
	}

	public List<List<Integer>> pairSum(int[] nums, int lo, int hi, int target) {
		List<List<Integer>> output = new ArrayList<>();
		while (lo < hi) {
			while (lo + 1 < hi) {
				if (nums[lo] == nums[lo + 1]) {
					lo++;
				} else {
					break;
				}
			}
			while (hi - 1 > lo) {
				if (nums[hi] == nums[hi - 1]) {
					hi--;
				} else {
					break;
				}
			}
			int tempsum = nums[lo] + nums[hi];
			if (tempsum < target) {
				lo++;
			} else if (tempsum > target) {
				hi--;
			} else {
				output.add(new ArrayList<>(List.of(nums[lo++], nums[hi--])));
			}
		}
		return output;
	}

	/** this is the actual solution
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> helper(int[] nums, int target) {
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum < target) {
					lo++;
				} else if (sum > target) {
					hi--;
				} else {
					output.add(List.of(nums[i], nums[lo], nums[hi]));
					lo++;
					while (nums[lo] == nums[lo - 1] && lo < hi) {
						lo++;
					}
				}
			}
		}
		return output;
	}

}
