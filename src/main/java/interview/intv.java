package interview;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class intv {
//	切分数组
	private int[] minPrime =new int[1000000+1];
	private Map<Integer,Integer> primeMinIndex = new HashMap<>();

	public static void main(String[] args){
		intv intv = new intv();
		int[] nums = {2,3,3,2,3,3};
		System.out.println(intv.splitArray(nums));

	}

	private void init(){
		for(int i = 2; i < minPrime.length; i++) {
			if (minPrime[i] <2) {
				for (int j = i; j < minPrime.length; j += i) {

						minPrime[j] = i;

				}
			}
		}
	}
	public int splitArray (int[] nums) {
//		 write code here
		init();
		int[] ans=new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			int n=nums[i];
			ans[i]=i>0?ans[i-1]+1:1;
			while(n>1) {
				int p=minPrime[n];
				int minIndex=-1;
				if(primeMinIndex.containsKey(p)) {
					minIndex=primeMinIndex.get(p);
				}else {
					minIndex=i;
					primeMinIndex.put(p, minIndex);
				}
				if(minIndex>0){
					ans[i]=Math.min(ans[i], ans[minIndex-1]+1);
				}else {
					ans[i]=1;
				}
				if(ans[i]<ans[minIndex]) {
					primeMinIndex.put(p, i);
				}
				n=n/p;

			}
		}
		return ans[nums.length-1];

	}

}
