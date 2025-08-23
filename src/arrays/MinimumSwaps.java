package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps {

	static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = InputClass.getIntArrayFromString(scn.nextLine());
		MinimumSwaps obj = new MinimumSwaps();
		System.out.println(obj.solve2(arr));
	}

	public int minSwaps(int arr[]) {

		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			idxMap.put(temp[i], i);
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (idxMap.get(arr[i]) != -1) {
				int count = 0;
				int currEle = arr[i];
				while (idxMap.get(currEle) != -1 && arr[idxMap.get(currEle)] != arr[i]) {
					count++;
					int tempNum = currEle;
					currEle = arr[idxMap.get(currEle)];
					idxMap.put(tempNum, -1);
				}
				ans += count;
				idxMap.put(currEle, -1);
			}
		}
		return ans;

	}

	public int solve2(int[] arr) {
		int ans = 0;
		int n = arr.length;
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < n; i++) {
			mp.put(arr[i], i);
		}
		Arrays.sort(arr);
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				int count = 0;
				int j = i;
				while (!visited[j]) {
					visited[j] = true;
					j = mp.get(arr[j]);
					count++;
				}
				ans += (count - 1);
			}
		}
		return ans;
	}

}
