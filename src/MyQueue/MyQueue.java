package MyQueue; //implement FIFO queue use linked list 

import LinkedList.LinkedList.ListNode;

public class MyQueue<E> {
	private int size;
	QueueNode<E> head;
	QueueNode<E> tail;
	
	public class QueueNode<E>{
		E val;
		QueueNode<E> next;
		
		QueueNode(E val){
			this.val=val;
			this.next=null;
		}
	}
	
	public void enQueue(E val){
			QueueNode<E> newnode=new QueueNode<>(val);
			if(tail!=null){
				tail.next=newnode;
			}
			tail=newnode;
			this.size++;
	}
	
	public E deQueue(){
		if(head!=null){
			E val=head.val;
			head=head.next;
			return val;
		}
		throw new java.util.NoSuchElementException();
	}
}
