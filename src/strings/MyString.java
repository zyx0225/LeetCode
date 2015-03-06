package strings;
import noname.ListNode;

import java.util.Arrays;

public class MyString {
	public void printReverseS(String s){
		if(s.length()==0){
			return;
		}
		System.out.print(s.charAt(s.length()-1));
		printReverseS(s.substring(0,s.length()-1));
	}
	public void reverseLL(ListNode previous){
		if(previous.next!=null){
			ListNode node=previous.next;
			reverseLL(previous.next);
			node.next=previous;
		}
	}
	public void reverse(String s){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length()-1;i++){
			sb.insert(0, s.charAt(i));
		}
		s=sb.toString();
	}//not in place, time and space both O(n)
	public void reverseNew(String s){
		char[] array=s.toCharArray();
		for(int i=0,j=array.length-2;i<j;i++,j--){
			char ch=array[i];
			array[i]=array[j];
			array[j]=ch;
		}
	}//in place, time O(n), space O(1)
	
	public int removeDuplicate1(char[] s){
		if(s==null){
			return 0;
		}
		if(s.length==0||s.length==1){
			return s.length;
		}
		int len=1;
		for(int i=1;i<s.length;i++){
			int j=0;
			for(j=0;j<len;j++){
				if(s[i]==s[j]){
					break;
				}
			}
			if(j==len-1&&s[i]!=s[j]){
				s[len-1]=s[j];
				len++;
			}
		}
		return len;
	}//time O(n^2), space O(1)
	
	public int removeDuplicate2(char[] s){
		boolean[] duplicate=new boolean[256];
		Arrays.fill(duplicate, false);
		if(s.length==0||s.length==1){
			return s.length;
		}
		int len=0;
		for(int i=0;i<s.length;i++){
			if(duplicate[s[i]]==false){
				duplicate[s[i]]=true;
				s[len]=s[i];				
				len++;
			}
		}
		return len;
	}//time O(n), use constant size extra space
}
