package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycle {

	public static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ls.add(scn.nextInt());
		}
		
		
	}

	public static ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;

	}

}
