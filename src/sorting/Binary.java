package sorting;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary b=new Binary();
		int[] input={3,56,1,3,7,2,9,6};
		b.binary(input,0,input.length-1);
		System.out.print("");
	}
	public void binary(int[] input, int start, int end){
		if(start>=end){
			return;
		}
		 int pivot=input[start];
		 int i=start,j=end;
		 while(i!=j){
			 while(j>i&&input[j]>=pivot){
				 j--;
			 }
			 if(i<j&&input[j]<pivot){
				 input[i]=input[j];
				 i++;
			 }
			 while(i<j&&input[i]<=pivot){
				 i++;
			 }
			 if(i<j&&input[i]>pivot){
				 input[j]=input[i];
				 j--;
			 }
		 }
		 input[i]=pivot;
		 binary(input,start,i-1);
		 binary(input,i+1,end);
	}
}
