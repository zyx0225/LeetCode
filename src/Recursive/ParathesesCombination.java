package Recursive;

import java.util.*;;

public class ParathesesCombination {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParathesesCombination pc=new ParathesesCombination();
		List<String> res=new ArrayList<>();
		String s=new String();
		pc.check(3,0,0,s,res);
		System.out.print(res);
	}
	
	public void check(int npairs, int left, int right, String s, List<String> res){
		if(right>left){
			return;
		}
		if(right==npairs&&left==npairs){
			res.add(s);
			return;
		}
		if(left<npairs){
			String news1=new String(s+"(");
			check(npairs, left+1, right, news1, res);
		}
		if(right<left){
			String news2=new String(s+")");
			check(npairs,left,right+1,news2,res);
		}
	} 
}
