package stack;

import java.util.Stack;

public class RedundentBrackets {

	public static void main(String[] args) {

		String s = "((a+b)+c)";
		System.out.println(check(s) == 1 ? "YES" : "NO");

	}

	/*
	 * 
	 * ((a + b) + (c)) (a + b + (c + d)) 3 0 ( 0
	 * 
	 */

	public static int check(String s) {

		Stack<Character> stk = new Stack<>();

		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stk.push((char) (count + '0'));
				stk.push(c);
				count = 0;
			} else if (c == ')') {
				if (count <= 2) {
					return 1;
				}
				stk.pop();
				Character prevCount = stk.pop();
				count = (prevCount - '0') + 1;
			} else {
				count++;
			}
		}

		return 0;

	}

}
