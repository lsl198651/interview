package com.shilong.interview.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayExplosion {
	public static int findMin(List<Integer> nums) {
		int sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
		}
		int firstSum = Integer.MAX_VALUE;
		int flag1 = 0;
		// 第一次爆炸
		for (int i = 1; i < nums.size() - 2; i++) {
			int windowSum = nums.get(i - 1) + nums.get(i) + nums.get(i + 1);
			if (firstSum > sum - windowSum) {
				firstSum = sum - windowSum;
				flag1 = i;
			}
		}
		List<Integer> firstNums = new ArrayList<>(nums.subList(0, flag1 - 1));
		firstNums.addAll(nums.subList(flag1 + 2, nums.size()));
		int secondSum = firstSum;
		int flag2 = 0;
		// 第二次爆炸
		for (int i = 1; i < firstNums.size() - 2; i++) {
			int windowSum = firstNums.get(i - 1) + firstNums.get(i) + firstNums.get(i + 1);
			if (secondSum > firstSum - windowSum) {
				secondSum = firstSum - windowSum;
				flag2 = i;
			}
		}
		return secondSum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(in.nextInt());
		}

		int result = findMin(nums);
		System.out.println(result);
	}
}