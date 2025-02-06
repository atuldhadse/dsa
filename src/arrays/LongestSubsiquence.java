package arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongestSubsiquence {

	static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] nums = InputClass.getIntArrayFromString(scn.nextLine());
		LongestSubsiquence obj = new LongestSubsiquence();
		System.out.println(obj.longestConsecutive(nums));
	}

	/**
	 * @param nums
	 * @return Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
	 *         consecutive elements sequence is [1, 2, 3, 4]. Therefore its length
	 *         is 4.
	 */
	public int longestConsecutive(int[] nums) {
		int longest = 0;
		Map<Integer, Boolean> mp = Arrays.stream(nums).distinct().boxed().collect(Collectors.toMap(n -> n, n -> false));
		for (int n : nums) {
			if (!mp.getOrDefault(n, true)) {
				int count = 1;
				int temp = n;
				while (!mp.getOrDefault(--temp, true)) {
					count++;
					mp.put(temp, true);
				}
				temp = n;
				while (!mp.getOrDefault(++temp, true)) {
					count++;
					mp.put(temp, true);
				}
				longest = Math.max(count, longest);
			}
		}
		return longest;
	}

}
