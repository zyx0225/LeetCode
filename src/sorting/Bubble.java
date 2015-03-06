package sorting;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bubble b=new Bubble();
		int[] input={3,56,1,3,7,2,9,6};
		b.bubble(input);
		System.out.print("");

	}
	public void bubble(int[] input){
		for(int j=input.length;j>0;j--){
			for(int i=1;i<j;i++){
				if(input[i]<input[i-1]){
					int temp=input[i];
					input[i]=input[i-1];
					input[i-1]=temp;
				}
			}
		}
	}
}
