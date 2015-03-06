package sorting;

public class FindPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPosition fp=new FindPosition();
		int[] rotate=new int[]{15,16,19,20,25,1,3,4,5,7,10};;
		System.out.println(fp.findPosition(rotate, 0, rotate.length-1, 5));

	}
	//find the position of given value in an rotated sorted array
	//find 19 in [15 16 19 20 25 1 3 4 5 7 10]
	public int findPosition(int[] rotate, int start, int end, int val){
		if(start>=end){
			return (rotate[start]==val)?start:-1; 
		}
		else{
			int mid=(start+end)/2;
			if(rotate[mid]==val){
				return mid;
			}
			if(rotate[start]<rotate[mid]){
				if(val>rotate[mid]){
					return findPosition(rotate, mid+1,end, val);
				}
				else{
					return findPosition(rotate, start, mid+1,val);
				}
			}else{
				if(val<rotate[mid]){
					return findPosition(rotate, start,mid-1, val);
				}
				else{
					return findPosition(rotate, mid+1, end,val);
				}
			}
		}
	}
}
