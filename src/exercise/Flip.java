package exercise;
import noname.*;

public class Flip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flip flip=new Flip();
		TreeNode n0=new TreeNode(0);
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		n0.left=n1;
		n0.right=n2;
		n1.left=n3;
		n1.right=n4;
		flip.flip(n0);
		n0.left=null;
		n0.right=null;
	}

	TreeNode newroot;

	public TreeNode flip(TreeNode node) {
		if (node.left == null) {
			newroot = node;
			node.left=node.right;
			return node;
		}
		TreeNode left = flip(node.left);
		TreeNode right = node.right;
		left.right = node;
		left.left = right;
		return node;
	}
}
