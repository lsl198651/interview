package leetCode;

public class lc189 {
	public static void main(String[] args){
		rotate(new int[]{1,2,3,4,5,6,7},3);

	}

	public static void rotate(int[] nums, int k) {
		int[]  temp=new int[nums.length];
		for(int i=0;i<temp.length;i++){
			if(i<k){
				temp[i]=nums[i+k+1];
			}else{
				temp[i]=nums[i-k];
			}

		}
		nums=temp;




	}
}
