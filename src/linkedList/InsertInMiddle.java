package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInMiddle {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ls.add(scn.nextInt());
		}
		int x = scn.nextInt();
		Node head = Node.getLL(ls);
		head = insertInMiddle(head, x);
		Node.printLL(head);

	}

	public static Node insertInMiddle(Node head, int x) {

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		Node middleNode = new Node(x);
		if (head == null) {
			head = middleNode;
		} else {
			Node temp = slow.next;
			slow.next = middleNode;
			middleNode.next = temp;
		}

		return head;

	}

}
