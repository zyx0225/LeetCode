package Recursive;

import java.util.*;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSet ss=new SubSet();
		char[] s={'1','2','3','4'};
		List<String> list=ss.BitManipulation(s);
		System.out.print(false);
	}
	
	
	public List<String> Iter(char[] s){
		List<String> res=new ArrayList<>();
		res.add("");
		for(int i=0;i<s.length;i++){
			char ch=s[i];
				int len=res.size();
			for(int j=0;j<len;j++){
				res.add(res.get(j)+ch);
			}
		}
		return res;
	}
	
	public List<String> recur(char[] s, List<String> res, int i){
		if(i==s.length){
			return res;
		}
		char ch=s[i];
		int len=res.size();
		for(int j=0;j<len;j++){
			res.add(res.get(j)+ch);
		}
		return recur(s,res,i+1);		
	}
	
	public List<String> BitManipulation(char[] s){
		//bit range between(0,2^(length-1))
		List<String> res=new ArrayList<>();
		for(int i=0;i<(1<<s.length);i++){
			String st=construct(s,i);
			res.add(st);
		}
		return res;
	}
	public String construct(char[] s, int m){
		String res=new String();
		for(int i=0;i<s.length;i++){
			if((m&1)==1){
				res=res+Character.toString(s[i]);
			}
			m=m>>1;
		}
		return res;
	}
}
