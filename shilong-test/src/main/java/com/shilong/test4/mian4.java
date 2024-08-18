package com.shilong.test4;

import java.util.Scanner;

public class mian4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++){
			array[i]=in.nextInt();
		}
		int[][][] times=new int[n][n][2];
		int sum=0;
		for(int i=0;i<n;i++){
			times[i][i][array[i]-1]=1;

			sum+=array[i];
		}
		for(int left=0;left<n;left++){
			for(int right=left+1;right<n;right++){
				int addIndex= array[right]-1;
				int stable=addIndex==0?1:0;
				times[left][right][addIndex]=times[left][right-1][addIndex]+1;
				times[left][right][stable]=times[left][right-1][stable];
				int mode=times[left][right][0]>=times[left][right][1]?1:2;
				sum+=mode;
			}
		}
		System.out.println(sum);
	}
}
