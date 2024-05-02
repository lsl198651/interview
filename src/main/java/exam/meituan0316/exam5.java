package exam.meituan0316;

import java.util.Scanner;

public class exam5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		int[] res=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=-arr[i];
			res[i]=count(arr,0,n-1);
			arr[i]=-arr[i];
		}
		for(int i=0;i<n;i++){
			System.out.print(res[i]+" ");
		}
	}
	private  static int count(int[] arr,int left,int right){
		if(left>=right){
			return 0;
		}
		int mid=(left+right)/2;
		int leftcount=count(arr,left,mid);
		int rightcount=count(arr,mid+1,right);
		int mergecount=merge(arr,left,mid,right);
		return leftcount+rightcount+mergecount;

	}
	private  static  int merge(int[] arr,int left, int mid,int right){
		int[] temp=new int[right-left+1];
		int i=left;
		int j=mid+1;
		int k=0;
		int count=0;
		while(i<=mid&&j<=right){
			if(arr[i]<=arr[j]){
				temp[k++]=arr[i++];
			}else{
				count+=mid-i+1;
				temp[k++]=arr[j++];
			}
		}
		while(i<=mid){
			temp[k++]=arr[i++];
		}
		while(j<=right){
			temp[k++]=arr[j++];
		}
		System.arraycopy(temp,0,arr,left,temp.length);
		return count;
	}
}
