package Recursive;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fb=new Fibonacci();
		int[] memo=new int[100];
		memo[1]=1;
		memo[2]=1;
		System.out.println(fb.generateRecur(5,memo));
	}
	
	public int generateRecur(int n, int[] memo){
		if(memo[n]!=0){
			return memo[n];
		}
		int res=generateRecur(n-1,memo)+generateRecur(n-2,memo);
		if(memo[n]==0){
			memo[n]=res;
		}
		return res;
	}
	public int generateIter(int n){
		if(n==0||n==1){
			return 1;
		}
		int preOne=1,preTwo=1;
		int res=0;
		for(int i=2;i<n;i++){
			res=preOne+preTwo;
			preTwo=preOne;
			preOne=res;	
		}
		return res;
	}
}
