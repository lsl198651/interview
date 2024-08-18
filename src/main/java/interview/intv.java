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

//小美和小团在一个数字矩阵中，小美站在矩阵的左上角，小团站在矩阵的右下角。小美可以向下或者向右走，当小美向下走一步时，小团向上走一步，当小美向右走一步时，小团向左走一步。
//小美和小团同时开始移动，他们每一步都选择最优的方向，直到他们在矩阵中相遇。请问他们相遇时，并且希望他们经过的全部矩阵各自1的数字之和尽可能大，这个和是多少？
//输入描述：
//第一行输入两个整数n,m，空格隔开代表矩阵的行数和列数
//接下来的n行,每行m个整数，空格隔开，代表矩阵中的数字
//输出描述：
//代表数字的最大和