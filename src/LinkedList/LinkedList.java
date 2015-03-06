package LinkedList;

public class LinkedList<E> {
	private int size;
	private ListNode<E> head;
	
	public class ListNode<E>{
		private E val;
		private ListNode<E> next;
		
		ListNode(E val){
			this.val=val;
			this.next=null;
		}
		
	}
	
	LinkedList(){
		this.size=0;
		this.head=null;
	}
	
	void add(E val){
		ListNode<E> newnode=new ListNode<>(val);
		ListNode<E> node=head;
		while(node.next!=null){
			node=node.next;
		}
		node.next=newnode;
		this.size++;
	}
}
