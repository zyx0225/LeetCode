package noname;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = new char[] {};
		int[] A = new int[] {1,2,3,4,5};
		
		ListNode n0=new ListNode(1); ListNode n1=new ListNode(1); ListNode
		 n2=new ListNode(2); ListNode n3=new ListNode(3); /*ListNode n4=new
		 ListNode(4);*/ //n0.next=n1; n1.next=n2; //n2.next=n3;//n3.next=n4;
		

		/*TreeNode n0 = new TreeNode(-2);
		TreeNode n1 = new TreeNode(1);
		n0.left = n1;*/
		Solution sl = new Solution();
		
		sl.maxXor(10, 15);
		
	}
	static int maxXor(int l, int r) {
        int res=0;
        int cur=1;
        int xor=l^r;
        while(cur<=r){
            if((xor&cur)==1||((l&cur)==0&&l+cur<=r)||((l&cur)==cur&&(r-cur>=l))){
                res+=cur;
            }
            cur=cur<<1;
        }
        return res;
    }
}
