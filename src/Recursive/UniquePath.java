package Recursive;

import java.util.Arrays;

public class UniquePath {
	int res=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePath up=new UniquePath();
		up.BackTracking(1, 1, 3, 3);
		System.out.print(up.res);

	}
	
	public int BottomUp(int m, int n){
		int[][] matrix=new int[m][n];
		Arrays.fill(matrix[m-1], 1);
		for(int i=0;i<m;i++){
			matrix[i][n-1]=1;
		}
		for(int i=n-2;i>=0;i--){
			for(int j=m-2;j>=0;j--){
				matrix[j][i]=matrix[j][i+1]+matrix[j+1][i];
			}
		}
		return matrix[0][0];
	}
	
	public boolean BackTracking(int x, int y, int m, int n){
		boolean success=false;
		if(x==m&&y==n){
			this.res++;
			return true;
		}
		if(x<m){
			success=BackTracking(x+1,y,m,n);
		}
		if(y<n){
			success=BackTracking(x,y+1,m,n);
		}
		return success;
	}
}
