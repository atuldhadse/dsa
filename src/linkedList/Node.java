package linkedList;

import java.util.List;

public class Node {

	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public static Node getLL(List<Integer> list) {
		
		Node head = null;
		Node prev = null;
		for (int ele : list) {
			Node curr = new Node(ele);
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
	
	public static void printLL(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
}
