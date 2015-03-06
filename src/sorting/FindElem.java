package sorting;

public class FindElem {
//find position in a sorted matrix
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindElem fe=new FindElem();
		int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(fe.findelem(matrix, 6,4,3));

	}
	public int[] findelem(int[][] matrix, int val, int m, int n){
		int colstart=0,colend=m-1;
		int rowstart=0, rowend=n-1;
		while(rowstart<rowend-1){
			int rowmid=(rowstart+rowend)/2;
			if(matrix[rowmid][0]==val){
				break;
			}else if(matrix[rowmid][0]<val){
				rowstart=rowmid;
			}else{
				rowend=rowmid-1;
			}
		}
		int row=rowstart;
		if(matrix[rowend][0]==val){
			row=rowend;
		}
		else{
			while(colstart<colend){
				int rowmid=(rowstart+rowend)/2;
				if(matrix[rowmid][0]==val){
					break;
				}else if(matrix[rowmid][0]<val){
					rowstart=rowmid;
				}else{
					rowend=rowmid-1;
				}
			}
		}
		int col=colstart;
		return new int[]{row,col};		
	}
}
