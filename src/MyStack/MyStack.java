package MyStack;

public class MyStack<E> {
	private int size;
	StackNode<E> top;
	
	public class StackNode<E>{
		E val;
		StackNode<E> next;
		
		StackNode(E val){
			this.val=val;
			this.next=null;
		}
	}
	
	MyStack(){
		this.size=0;
		this.top=null;
	}
	
	public E pop(){
		E val=this.top.val;
		top=top.next;
		return val;
	}
	public void push(E val){
		StackNode newnode=new StackNode(val);
		newnode.next=top;
		top=newnode;
	}
}
