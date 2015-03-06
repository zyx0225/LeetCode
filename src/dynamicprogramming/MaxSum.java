package dynamicprogramming;

public class MaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSum ms=new MaxSum();
		int[] input={1,2,3,-1,5,-4};
		int[] res=ms.findmaxSum(input);
		System.out.print(res);
	}
	
	public int[] findmaxSum(int[] input){
		int[] res=new int[3];//start index, end index, maxsum
		if(input.length==0){
			return res;
		}
		res[2]=Integer.MIN_VALUE;
		maxSum(input, 0, res);
		return res;
	}
	//output the max sum of continues elem in an input array
	//basic idea, DP, assum we compare all subarray which begin at index i
	//maxSum(i)=Max(maxSum(i+1)+input[i], input[i])
	public int maxSum(int[] input, int index, int[] res){
		int sum=0;
		int end=0;
		if(index==input.length-1){
			end=index;
			sum=input[index];
		}
		else{
			int pre=maxSum(input, index+1, res);
			if(pre>0){
				end=res[1];
				sum=pre+input[index];
			}else{
				end=index;
				sum=input[index];
			}
		}
		if(sum>res[2]){
			res[0]=index;
			res[1]=end;
			res[2]=sum;
		}
		return sum;
	}
}
