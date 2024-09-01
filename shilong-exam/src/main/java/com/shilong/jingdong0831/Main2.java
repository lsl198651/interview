package com.shilong.jingdong0831;

import java.util.Scanner;

	public class Main2 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int minOps = countMinOps(arr);
			System.out.println(minOps);
		}

		private static int countMinOps(int[] arr) {
			int n = arr.length;
			int count = 0;

			// 尽可能多地进行三元素交换操作，将大的数字尽量移动到靠后的位置
			for (int i = n - 1; i >= 0; i--) {
				int maxIndex = findMaxIndex(arr, i);
				while (maxIndex < i) {
					if (maxIndex + 2 <= i) {
						// 通过三元素交换将 maxIndex 元素向后移动
						swapThree(arr, maxIndex, maxIndex + 1, maxIndex + 2);
						maxIndex += 2;
					} else {
						break;
					}
				}
			}

			// 使用两元素交换操作完成最终排序
			for (int i = 0; i < n - 1; i++) {
				while (i < n - 1 && arr[i] > arr[i + 1]) {
					swapTwo(arr, i, i + 1);
					count++;
				}
			}

			return count;
		}

		// 找到从0到end区间内的最大值的索引
		private static int findMaxIndex(int[] arr, int end) {
			int maxIndex = 0;
			for (int i = 1; i <= end; i++) {
				if (arr[i] > arr[maxIndex]) {
					maxIndex = i;
				}
			}
			return maxIndex;
		}

		// 交换三个数
		private static void swapThree(int[] arr, int i, int j, int k) {
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}

		// 交换两个数
		private static void swapTwo(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

