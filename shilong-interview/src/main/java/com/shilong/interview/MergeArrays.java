package com.shilong.interview;import java.util.*;

public class MergeArrays {
	public static List<Integer> mergeAndReturnMaxN(int[] a, int[] b, int n) {
		List<Integer> mergedList = new ArrayList<>();

		// 合并两个数组
		for (int num : a) {
			mergedList.add(num);
		}
		for (int num : b) {
			mergedList.add(num);
		}

		// 对合并后的数组进行排序
		Collections.sort(mergedList);

		// 返回最大的N个数
		List<Integer> maxNList = new ArrayList<>();
		int size = mergedList.size();
		for (int i = Math.max(0, size - n); i < size; i++) {
			maxNList.add(mergedList.get(i));
		}

		return maxNList;
	}
	/*替代场景：

	分享者可以选择分享特定的应用窗口，而不是整个设备的显示器。
	分享者可以切换分享的设备的显示器或应用窗口，以便展示不同的内容。
	分享者可以暂停和恢复屏幕分享，以便处理私密信息或进行其他操作。
	异常场景：

	如果分享者的设备没有可分享的显示器或应用窗口，分享无法进行。
	如果分享者的应用程序崩溃或出现故障，屏幕分享可能会中断或无法正常工作。
	如果观看者的应用程序崩溃或出现故障，无法观看分享者的屏幕分享。
	备注：
	在实际应用中，屏幕分享功能通常还会涉及到权限管理、画面质量调整、录制等其他功能。以上用例设计提供了基本的框架，具体的实现和细节需要根据应用程序的要求和技术选择进行进一步的设计和开发。*/

	public static void main(String[] args) {
		int[] a = {5, 2, 9, 1};
		int[] b = {7, 4, 8, 3};
		int n = 3;



		List<Integer> result = mergeAndReturnMaxN(a, b, n);

		System.out.println(result);
	}
}
/*
接下来进行用例设计，题目如下：
屏幕分享需求

1 可以分享设备的显示器、应用窗口
2.分学过程中可以切换分享中的显示器、窗口
3口以启动、停上、暂停、恢复分享
4.同时只能存在一个共享画面，通话中的所有人都可以观看*/
