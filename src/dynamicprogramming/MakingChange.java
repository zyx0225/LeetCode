package dynamicprogramming;

public class MakingChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakingChange mc=new MakingChange();
		int[] values={1,2,5};
		int [] res=mc.change(values, 57);
		System.out.print(res);
	}
	//given different values of coins, starting from 0, and total amount, find ways to change into coins with as few coins as possible
	public int[] change(int[] values, int amount){
		int[] res=new int[values.length];
		int remain=amount;
		for(int i=values.length-1;i>0;i--){
			if(remain>=values[i]){
				res[i]=remain/values[i];
				remain=remain%values[i];
			}
		}
		res[0]=remain;
		return res;
	}
}
