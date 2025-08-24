package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseKGroup {

	public static final Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ls.add(scn.nextInt());
		}
		int x = scn.nextInt();
		Node head = Node.getLL(ls);
		head = reverseKGroup(head, x);
		Node.printLL(head);
		
	}

	/*
	 	
	 	1 -> 2 -> 3 -> null
	 	
	 	1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, k = 3 ==> 3 -> 2 -> 1 -> null
	 	
	 	1 -> 2 -> 3 -> 4 -> 5 -> null, k = 3 ==> 3 -> 2 -> 1 -> 4 -> 5 -> null
	 	
	*/
	
	public static Node reverseKGroup(Node head, int k) {
		
		if (k <= 1) {
			return head;
		}
		
		int l = len(head);
		
		Node newHead = null;
		Node prevTail = null;
		
		for (int i = 0; i < l / k; i++) {
			Node tail = head;
			Node prev = null;
			for (int j = 0; j < k; j++) {
				Node next = head.next;
				head.next = prev;
				prev = head;
				head = next;
			}
			if (newHead == null) {
				newHead = prev;
			}
			if (prevTail != null) {
				prevTail.next = prev;
			}
			prevTail = tail;
		}
		
		prevTail.next = head;
		return newHead;
		
	}
	
	public static int len(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

}
