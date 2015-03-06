package exercise;

import noname.*;

public class SwapNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n0=new ListNode(0);
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		n0.next=n1;
		n1.next=n2;
		SwapNodes sn=new SwapNodes();
		sn.swap(n0);
	}

	public ListNode swap(ListNode head) {
		// only one elem or null
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode newhead = node.next;
		if (node.next != null) {
			ListNode next = node.next;
			node.next = swap(next.next);
			next.next = node;
		}
		return newhead;
	}

}
