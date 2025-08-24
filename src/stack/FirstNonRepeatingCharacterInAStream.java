package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingCharacterInAStream {

	public static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String s = scn.nextLine();
		System.out.println(solve(s));

	}

	/*
	 * 
	 * aabc
	 * 
	 */

	public static String solve(String s) {

		StringBuilder sb = new StringBuilder();

		Map<Character, Integer> freq = new HashMap<>();
		Queue<Character> q = new LinkedList<>();

		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
			if (freq.get(c) == 1) {
				if (q.isEmpty()) {
					sb.append(c);
				} else {
					while (!q.isEmpty() && freq.get(q.peek()) != 1) {
						q.poll();
					}
					if (q.isEmpty()) {
						sb.append(c);
					} else {
						sb.append(q.peek());
					}
				}
				q.add(c);
			} else {
				if (q.isEmpty()) {
					sb.append('#');
				} else {
					while (!q.isEmpty() && freq.get(q.peek()) != 1) {
						q.poll();
					}
					if (q.isEmpty()) {
						sb.append('#');
					} else {
						sb.append(q.peek());
					}
				}
			}
		}

		return sb.toString();

	}

}
