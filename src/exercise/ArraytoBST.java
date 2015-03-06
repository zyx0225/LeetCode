package exercise;
import noname.*;

public class ArraytoBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=new int[]{0,1,2,3,4,5};
		ArraytoBST ab=new ArraytoBST();
		TreeNode head=ab.ArraytoBST(array, 0, array.length-1);
		System.out.print("");
	}

	public TreeNode ArraytoBST(int[] array, int start, int end) {
		if (start >end) {
			return null;
		} else if (start == end) {
			TreeNode node=new TreeNode(array[start]);
			return node;
		} else {
			int mid = (start + end) / 2;
			TreeNode node = new TreeNode(array[mid]);
			node.left = ArraytoBST(array, start, mid - 1);
			node.right = ArraytoBST(array, mid + 1, end);
			return node;
		}
	}

}
