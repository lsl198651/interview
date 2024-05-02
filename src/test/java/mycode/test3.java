package mycode;
//游游拿到了一个 01 矩阵，她每次操作可以选择一个 1*2（1 行 2 列，不能 2 行 1 列）的区域，将所有字符都变成 1。
// 游游想知道，将所有字符都变成 1 需要最少操作多少次？

import java.util.Scanner;

public class test3 {
	private static String s;

	public static void main(String[] args){
		
			Scanner in = new Scanner(System.in);
			// 注意 hasNext 和 hasNextLine 的区别
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matrix = new int[n][m];
		for(int i=0;i<n;i++){
			String s= in.next();
			char[] c = s.toCharArray();
			int[] a = new int[c.length];
			for(int j=0;j<c.length;j++){
				a[j] = c[j]-'0';
			}
			matrix[i] = a;
		}

		int result = minOper(matrix);
		System.out.println(result);

		if(n==1&&m==1){
			System.out.println(1);
		}
		else if(n==1){
			int count=0;
			for(int i=0;i<m-1;i++){
				if(matrix[0][i]==0&&matrix[0][i+1]==0){
					count++;
					i++;
				}
			}
			System.out.println(count);
		}
		else if(m==1){
			int count=0;
			for(int i=0;i<n-1;i++){
				if(matrix[i][0]==0&&matrix[i+1][0]==0){
					count++;
					i++;
				}
			}
			System.out.println(count);
		}
		else{
			int count=0;
			for(int i=0;i<n-1;i++){
				for(int j=0;j<m-1;j++){
					if(matrix[i][j]==0&&matrix[i][j+1]==0&&matrix[i+1][j]==0&&matrix[i+1][j+1]==0){
						count++;
						j++;
					}
				}
			}
			System.out.println(count);
		}

	}

	public  static  int minOper(int[][] max){
		int count=0;
		for(int row=0; row<max.length; row++){
			for(int col=0; col<max[row].length-1; col+=2){
				if(max[row][col]==0||max[row][col+1]==0){
					count ++;
				}
			}
		}
		return count;
	}
}
