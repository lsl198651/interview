package com.shilong.meituan0316;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exam3 {
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		  long sum=0L;
		  int MOD=1000000007;
		  int n=in.nextInt();
		  int q=in.nextInt();
		  int[] a=new int[n];
		  for(int i=0;i<n;i++){
			  a[i]=in.nextInt();
			  sum+=a[i];
		  }
		  sum=(sum<<q)%MOD;
		Map<Integer,Integer> exclude=new HashMap<>();
		for(int i=0;i<q;i++){
			int excludeIndex=in.nextInt()-1;
			exclude.put(excludeIndex,exclude.getOrDefault(excludeIndex,1));
		}
		for(Map.Entry<Integer,Integer> entry:exclude.entrySet()){
			sum=sum-((a[entry.getKey()]<<q)%MOD-(a[entry.getKey()]<<entry.getValue())%MOD);
		}
		System.out.println((int)sum);
	}
}
