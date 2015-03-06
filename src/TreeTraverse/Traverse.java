package TreeTraverse;
import java.util.Stack;

import noname.*;

public class Traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		TreeNode n7=new TreeNode(7);
		n0.left = n1;
		n0.right=n2;
		n2.right=n5;
		n1.left=n3;
		n1.right=n4;
		n4.left=n6;
		n4.right=n7;
		Traverse tr=new Traverse();
		tr.IterativeIn(n0);
	}
	
	
	//DFS
	public void RecursiveIn(TreeNode node){
		if(node == null)
			return;
		RecursiveIn(node.left);
		System.out.println(node.val);
		RecursiveIn(node.right);
	}
	
	public void RecursivePre(TreeNode node){
		if(node == null)
			return;
		System.out.println(node.val);
		RecursivePre(node.left);
		RecursivePre(node.right);
	}
	
	public void RecursivePost(TreeNode node){
		if(node == null)
			return;
		RecursivePost(node.left);
		RecursivePost(node.right);
		System.out.println(node.val);
	}
	
	//using stack
	public void IterativePre(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
    		System.out.println(node.val);            
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
	}
	
	public void IterativePost(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode node=root;
        do{
        	while(node != null){
        		if(node.right!=null)
        			stack.push(node.right);
        		stack.push(node);
        		node=node.left;
        	}
        	node=stack.pop();
        	if(!stack.isEmpty()&&node.right!=null&&stack.peek()==node.right){
        		stack.pop();
        		stack.push(node);
        		node=node.right;        		
        	}else{
        		System.out.println(node.val);
        		node=null;
        	}
        }while(!stack.isEmpty());
	}
	
	public void IterativeIn (TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode node=root;
		while(true){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(stack.isEmpty())
				break;
			node=stack.pop();
			System.out.println(node.val);
			node=node.right;
		}
	}
}
