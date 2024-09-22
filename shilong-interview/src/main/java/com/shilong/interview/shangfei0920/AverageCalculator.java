package com.shilong.interview.shangfei0920;

public class AverageCalculator {

	// 计算数组的平均值
	public static float calculateAverage(int[] array, int size) {
		if (size == 0) {
			throw new IllegalArgumentException("Size must be greater than 0");
		}

		int sum = 0;

		// 遍历数组求和
		for (int i = 0; i < size; i++) {
			sum += array[i];
		}

		// 计算平均值
		return (float) sum / size;
	}

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};
		float average = calculateAverage(numbers, numbers.length);
		System.out.println("Average: " + average);
	}
}

