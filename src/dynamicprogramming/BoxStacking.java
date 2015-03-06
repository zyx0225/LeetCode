package dynamicprogramming;

public class BoxStacking {
	int maxval=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxStacking bs=new BoxStacking();
		int boxno=4;
		int[] height={4,1,4,10};
		int[] width={6,2,5,12};
		int[] depth={7,3,6,32};
		int[][] after=bs.construct(boxno,height,width,depth);
		bs.sortbybase(after,0,after.length-1);
		int[] maxheight=new int[boxno*3];
		for(int i=0;i<boxno*3;i++){
			bs.boxstack(after,boxno*3,maxheight,i);
		}
		System.out.println(bs.maxval);
	}
	
	public int[][] construct(int boxno, int[] height, int[] width, int[] depth){
		int[][] res=new int[boxno*3][4];
		for(int i=0;i<boxno;i++){
			res[3*i][0]=height[i];
			res[3*i][1]=width[i]*depth[i];
			res[3*i][2]=(width[i]>depth[i])?width[i]:depth[i];
			res[3*i][3]=(width[i]>depth[i])?depth[i]:width[i];
			res[3*i+1][0]=width[i];
			res[3*i+1][1]=height[i]*depth[i];
			res[3*i+1][2]=(height[i]>depth[i])?height[i]:depth[i];
			res[3*i+1][3]=(height[i]>depth[i])?depth[i]:height[i];
			res[3*i+2][0]=depth[i];
			res[3*i+2][1]=width[i]*height[i];
			res[3*i+2][2]=(width[i]>height[i])?width[i]:height[i];
			res[3*i+2][3]=(width[i]>height[i])?height[i]:width[i];			
		}
		return res;
	}
	public void sortbybase(int[][] input, int start, int end){
		if(start>=end){
			return;
		}
		 int pivot=input[start][1];
		 int temp1=input[start][0];
		 int temp2=input[start][2];
		 int temp3=input[start][3];
		 int i=start,j=end;
		 while(i!=j){
			 while(j>i&&input[j][1]>=pivot){
				 j--;
			 }
			 if(i<j&&input[j][1]<pivot){
				 input[i][1]=input[j][1];
				 input[i][0]=input[j][0];
				 input[i][2]=input[j][2];
				 input[i][3]=input[j][3];
				 i++;
			 }
			 while(i<j&&input[i][1]<=pivot){
				 i++;
			 }
			 if(i<j&&input[i][1]>pivot){
				 input[j][1]=input[i][1];
				 input[j][0]=input[i][0];
				 input[j][2]=input[i][2];
				 input[j][3]=input[i][3];
				 j--;
			 }
		 }
		 input[i][1]=pivot;
		 input[i][0]=temp1;
		 input[i][2]=temp2;
		 input[i][3]=temp3;
		 sortbybase(input,start,i-1);
		 sortbybase(input,i+1,end);
	}
	//we can solve this in two ways:
	//(1) DP: H(i)=max(H(j))+h(i) where j is the first one with larger base area, no sort
	//(2) my iterative algorithm, need sort
	
	
	//Recursive DP method
	public void boxstack(int[][] input, int len, int[] maxheight, int index){
		if(index==0){
			maxheight[0]=input[0][0];
			return; 
		}
		else{
			int i=findpre(input, index);
			if(i==-1){
				maxheight[index]=input[index][0];
			}else{
				if(maxheight[i]==0){
					boxstack(input, len,maxheight, i);
				}else{
					maxheight[index]=maxheight[i]+input[index][0];
				}
			}
		}
		maxval=(maxheight[index]>maxval)?maxheight[index]:maxval;
	}
	public int findpre(int[][] input, int index){
		if(index==0){
			return -1;
		}
		int i=0;
		for(i=index-1;i>0;i--){
			if(input[i][2]<input[index][2]&&input[i][3]<input[index][3]){
				return i;
			}
		}
		if(i==0&&(input[i][2]<input[index][2]&&input[i][3]<input[index][3])){
			return 0;
		}
		return -1;
	}
	//Iterative DP method
	/*public int[][] boxstack(int[][] input, int len){
		int[][] stack=new int[len][len];//record box stack ending with that box
		int[] height=new int[len];
		int[] boxcount=new int[len];
		int maxheight=0;
		for(int i=0;i<len;i++){
			if(i==0){
				stack[i][0]=0;
				height[i]=input[0][0];
				boxcount[i]++;
			}
			else{
				int j=i-1;
				while(j>0&&!(input[j][2]<input[i][2]&&input[j][3]<input[i][3])){
					j--;
				}
				if(j>=0&&(input[j][2]<input[i][2]&&input[j][3]<input[i][3])){
					stack[i]=Arrays.copyOf(stack[j], len);
					height[i]=height[j]+input[i][0];
					boxcount[i]=boxcount[j]+1;
					stack[i][boxcount[i]-1]=i;
				}else{
					stack[i][0]=i;
					height[i]=input[i][0];
					boxcount[i]++;
				}
			}
			maxheight=(height[i]>height[maxheight])?i:maxheight;
		}
		int[][] res=new int[2][len];//the first row is maxheight, second row is corresponding box stack
		res[0][0]=height[maxheight];
		res[1]=Arrays.copyOf(stack[maxheight], len);
		return res;
	} */
}
