package tree;
import java.util.*;
//implementation of Binary Search Tree

public class Tree<E> {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode<E> root;
	
	public class TreeNode<E>{
		E val;
		TreeNode<E> LChild;
		TreeNode<E> RChild;
		
		public TreeNode(E val){
			this.val=val;
			this.LChild=null;
			this.RChild=null;
		}
	}
	
	public Tree(){
		this.root=null;
	}
	
	public void insert(E val, TreeNode<E> root){
		//recursively find the right parent position
		TreeNode<E> newnode=new TreeNode<>(val);
		if(root==null){
			return;
		}
		if(root.val<val){
			insert(val,root.LChild);
		}
		else{
			insert(val,root.RChild);
		}
	}
	
	
	public void delete(E val, TreeNode<E> root){
		//if node to be deleted has only one child,, just replace it with its child;
		//if node to be deleted has two children, find the smallest in its right subtree, replace their values, and delete the smallest one
		if(root.val>val){
			delete(val,root.RChild);
		}
		if(root.val<val){
			delete(val,root.LChild);
		}
		if(root.val==val){
			if(root.LChild==null){
				root=root.RChild;
				return;
			}
			if(root.RChild==null){
				root=root.LChild;
				return;
			}
			TreeNode<E> min=findMin(root);
			root.val=min.val;
			if(root==min){
				root=null;
				return;
			}
			delete(min.val,root.LChild);			
		}
	}
	public TreeNode<E> findMin(TreeNode<E> root){
		if(root.LChild==null){
			return root;
		}
		return findMin(root.LChild);
	}
	public TreeNode<E> findMax(TreeNode<E> root){
		if(root.RChild==null){
			return root;
		}
		return findMax(root.RChild);
	}
	
	public TreeNode<E> search(E val,TreeNode<E> root){
		if(root.val==val){
			return root;
		}else if(root.val<val){
			return search(val,root.LChild);
		}else{
			return search(val,root.RChild);
		}
	}
	
	//DFS: pre-order, in-order, post-order recursively traverse
	public void DFS(TreeNode<E> root, List<TreeNode<E>> res){
		if(root==null){
			return;
		}
		if(root.LChild!=null){
			DFS(root.LChild,res);
		}
		res.add(root);
		if(root.RChild!=null){
			DFS(root.RChild,res);
		}
	}
	
	//BFS by-level traverse iteratively
	public void BFS(TreeNode<E> root, List<TreeNode<E>> res){
		if(root==null){
			return;
		}
		res.add(root);
		int i=0;
		while(i<res.size()){
			TreeNode<E> node=res.get(i);
			if(node.LChild!=null){
				res.add(node.LChild);
				i++;
			}
			if(node.RChild!=null){
				res.add(node.RChild);
				i++;
			}
		}
	}
}
