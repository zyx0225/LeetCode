package sorting;

import java.util.Arrays;

import Recursive.Fibonacci;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms=new MergeSort();
		int[] a=new int[]{1,4,7};
		int[] b=new int[]{2,4,5};
		//ms.combine(a, 3, b, 3);
		int[] input={3,2,5,2,2,4,1};
		ms.mergeSort2(input);
		System.out.println();
	}
	//merge from the back can avoid shifting
	public void combine(int[] a, int m, int[] b, int n){
		int k=m+n-1;
		int i=m-1;
		int j=n-1;
		while(i>=0&&j>=0){
			if(a[i]>b[j]){
				a[k]=a[i];
				k--;
				i--;
			}else{
				a[k]=b[j];
				k--;
				j--;
			}
		}
		while(i>=0){
			a[k]=a[i];
			k--;
			i--;
		}
		while(j>=0){
			a[k]=b[j];
			k--;
			j--;
		}
	}
	
	
	
	//iteratively merge sort an array O(nlgn)
	public void mergeSort2(int[] input){
		for(int blocksize=1;blocksize<input.length;blocksize*=2){
			for(int start=0;start<input.length;start+=2*blocksize){
				int[] a1=Arrays.copyOfRange(input, start, Math.min(start+blocksize, input.length));
				int[] a2=Arrays.copyOfRange(input, Math.min(start+blocksize, input.length),Math.min(start+2*blocksize, input.length));
				int[] res=merge(a1,a2);
				for(int i=start;i<Math.min(start+2*blocksize, input.length);i++){
					input[i]=res[i-start];
				}
			}
		}
	}
	
	
	//recursively mergeSort
	public void mergeSort(int[] input, int start, int end){
		if(start>=end){
			return;
		}else{
			int mid=(start+end)/2;
			mergeSort(input,start, mid);
			int[] a1=Arrays.copyOfRange(input, start, mid+1);
			mergeSort(input, mid+1,end);
			int[] a2=Arrays.copyOfRange(input, mid+1, end+1);
			int[] res=merge(a1,a2);
			for(int i=start;i<=end;i++){
				input[i]=res[i-start];
			}
		}
	}
	
	
	
	//merge two sorted arrays
	public int[] merge(int[] a1, int[] a2){
		int m=a1.length-1;
		int n=a2.length-1;
		int k=m+n+1;
		int[] res=new int[k+1];
		while(m>=0&&n>=0){
			if(a1[m]>a2[n]){
				res[k]=a1[m];
				k--;
				m--;
			}else{
				res[k]=a2[n];
				k--;
				n--;
			}
		}
		while(m>=0){
			res[k]=a1[m];
			k--;
			m--;
		}
		while(n>=0){
			res[k]=a2[n];
			k--;
			n--;
		}
		return res;
	}
}
