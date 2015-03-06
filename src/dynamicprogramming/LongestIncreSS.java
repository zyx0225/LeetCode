package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreSS ls=new LongestIncreSS();
		int[] input={1,-4,3,6,4,8,2};
		int[] res=ls.find(input);
		System.out.print(res);
	}
	//given an array of integer, find the longest subsequence (not necessarily continues) with rig increasing order
	//DP: basic idea,let sub[i] denote the longest increasing subsequence ending at i;
	//then we have sub[i]=sub[j]+input[i+1] where j is the largest index where input[j]<input[i], this is of complexity O(n^2)
	//we can also sort the input and then find the answer, this would take O(nlgn)+O(n) time complexity
	public int[] find(int[] input){
		int[][] res=new int[input.length][input.length];
		int[] sublen=new int[input.length];
		int longest=0;
		for(int i=0;i<input.length;i++){
			if(i==0){
				res[0][0]=input[i];
				sublen[0]=1;
			}
			else{
				int k=i-1;
				while(k>=0&&input[k]>=input[i]){
					k--;
				}
				if(k>=0){
				sublen[i]=sublen[k]+1;
				res[i]=Arrays.copyOf(res[k], input.length);
				res[i][sublen[i]-1]=input[i];}
				else{
				sublen[i]=1;
				res[i][0]=input[i];}
				longest=(sublen[i]>sublen[longest])?i:longest;
			}
		}
		return res[longest];		
	}

}
