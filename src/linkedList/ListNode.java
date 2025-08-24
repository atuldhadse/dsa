package linkedList;

import java.util.List;

public class ListNode {

	int val;

	ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode() {

	}

	public static ListNode getLL(List<Integer> list) {

		ListNode head = null;
		ListNode prev = null;
		for (int ele : list) {
			ListNode curr = new ListNode(ele);
			if (head == null) {
				head = curr;
				prev = curr;
			} else {
				prev.next = curr;
				prev = curr;
			}
		}
		return head;

	}

	public static void printLL(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}

}
