package com.shilong.interview.others;
import java.util.*;


	public class myGhost {
		/*public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			// 注意 hasNext 和 hasNextLine 的区别

			int n = in.nextInt();
			int k = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			in.close();
			System.out.println(maxSum(nums, k));

		}

		public static int maxSum(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k < 1) {
				return 0;
			}
			int[][] dp = new int[nums.length + 1][nums.length + 1];
			for (int i = 1; i <= nums.length; i++) {

				for (int j = i; j <= nums.length; j++) {
					if (i == 1) {
						dp[i][j] = nums[j - 1];
					} else if (j - i >= k) {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j-k - 1] + nums[j - 1]);
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
			return dp[nums.length][nums.length];
		}*/
		/*public static void main(String[] args){
			Scanner in = new Scanner(System.in);
				// 注意 hasNext 和 hasNextLine 的区别

				int n = in.nextInt();
				int k = in.nextInt();
				String beanColor=in.nextLine();
				String instructions=in.nextLine();
				int maxBeans=countMaxBeans(beanColor,instructions);
				System.out.println(maxBeans);

		}
		public static int countMaxBeans(String beanColor,String instructions){
			int i=0,j=0;
			int maxBeans=0;
			while(i<beanColor.length()&&j<instructions.length()){
				if(instructions.charAt(j)=='*'){
					if(j>0){
						char preColor=instructions.charAt(j-1);
						while (i<beanColor.length()&&beanColor.charAt(i)!=preColor){
							maxBeans++;
							i++;
						}
					}
					j++;
				}else if(instructions.charAt(j)==beanColor.charAt(i)){
					maxBeans++;
					j++;
					i++;
				}else {
					j++;
				}
			}
			return maxBeans;
		}*/
		static final int MAX_TOURIST=1005;
		static final double ESP =1e-6;
		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			// 注意 hasNext 和 hasNextLine 的区别
			int t = in.nextInt();
			int k = in.nextInt();
		in.nextLine();
		double[][] dp = new double[MAX_TOURIST][MAX_TOURIST];
		double[][] mn=new double[t+1][2];
		for(int i=1;i<=t;i++){
			String[] parts=in.nextLine().split(" ,");
			if (parts.length != 4) {
				System.out.println("Invalid input");
				return;
			}

			mn[i][0]=Double.parseDouble(parts[0]);
			mn[i][1]=Double.parseDouble(parts[1]);
			parts[2]=parts[2].substring(1,parts[2].length()-1);
			parts[3]=parts[3].substring(0,parts[3].length()-2);
			int x=Integer.parseInt(parts[2]);
			int y=Integer.parseInt(parts[3]);
			dp[i][0]=Math.hypot(x,y);
			for(int j=1;j<i;j++){
				dp[j][i]=Math.hypot(x-Integer.parseInt(parts[2]),y-Integer.parseInt(parts[3]));
			}
		}
			double [][][] dp2=new double[t+1][k+1][t+1];
			for(double[][] arr:dp2){
				for(double[] arr2:arr){
					Arrays.fill(arr2,-Double.MAX_VALUE);
				}
			}
			dp2[0][0][0]=0;
			for(int i=1;i<=t;i++){
				for(int j=1;j<=k;j++){
					for(int l=0;l<i;l++){
						double newCm=dp2[i-1][j-1][l]+dp[l][i];
						double newCn=dp2[i-1][j][l]+mn[i][1];
						double newDp=newCn/(newCm+mn[i][0]);
						dp2[i][j][i]=Math.max(dp2[i][j][i],newDp);
						if(j<k){
							dp2[i][j+1][i]=Math.max(dp2[i][j+1][i],dp2[i-1][j][l]);
						}
					}
				}
			}
			double maxOmfort=-Double.MAX_VALUE;
			for(int i=1;i<=t;i++){
				double comfort=dp2[t][k][i]+mn[i][1]/(dp2[t][k][i]+dp[i][0]+mn[i][0]);
				maxOmfort=Math.max(maxOmfort,comfort);

			}
			System.out.printf("%.6f\n",maxOmfort);
			}

	}

