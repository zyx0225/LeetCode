package Recursive;
import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens nq=new NQueens();
		nq.GenerateAllArrange(4);
	}
	public void GenerateAllArrange(int n){
		char[][] board=new char[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(board[i], '*');
		}
		int[] Queens=new int[n];
		check(n, 0, board,Queens);
		
	}
	
	public void check(int n, int i, char[][] board, int[] Queens){
		if(i!=n){
		for(int position=0;position<n;position++){
			if(feasible(position, board, i,n)){
				board[i][position]='Q';
				Queens[i]=position;
				check(n, i+1, board, Queens);
			}
		}
			if(i==0){
				return;
			}
			board[i-1][Queens[i-1]]='*';
		}
		else{System.out.println("One way to put:");
		for(int j=0;j<n;j++){
			String a=new String(board[j]);
			System.out.println(a);
		}
		board[i-1][Queens[i-1]]='*';}
	}
	
	public boolean feasible(int position, char[][] board, int i, int n){
		for(int j=0;j<i;j++){
			int k=0;
			while(board[j][k]!='Q'){
				k++;
			}
			if(k==position||Math.abs(j-i)==Math.abs(position-k)){
				return false;
			}
		}
		return true;
	}
	
}
