package sorting;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Selection b=new Selection();
		int[] input={3,56,1,3,7,2,9,6};
		b.selection(input);
		System.out.print("");
	}
	public void selection(int[] input){
		for(int j=0;j<input.length;j++){
			int smallest=j;
			for(int i=j;i<input.length;i++){
				if(input[i]<input[smallest]){
					smallest=i;
				}
			}
			int temp=input[smallest];
			input[smallest]=input[j];
			input[j]=temp;
		}
	}
}
