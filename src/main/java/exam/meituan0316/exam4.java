package exam.meituan0316;

import java.util.ArrayList;
import java.util.List;

public class exam4 {

	public static void main(String[] args) {

		int n = 3;
		List<Integer> shuzu = new ArrayList<>();
		shuzu.add(2);
		shuzu.add(1);
		shuzu.add(2); // 或者使用循环从用户处获取输入

		int now_1 = 0; // 记录1的个数
		int now_2 = 0; // 记录2的个数（注意：在原始C++代码中并没有2的存在，这里我假设是为了通用性而保留的）

		List<List<Integer>> jilu = new ArrayList<>(); // 二维列表记录对应位置的a,b的数量
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		tmp.add(0);

		for (int i = 0; i < n; i++) { // 遍历数组，记录a，b的数量
			if (shuzu.get(i) == 1) {
				now_1++;
			} else {
				now_2++; // 假设存在非1的元素，并且这里将其视为2
			}
			tmp.set(0, now_1);
			tmp.set(1, now_2);
			jilu.add(new ArrayList<>(tmp));
		}

		int sum = 0;
		for (int i = 0; i < n; i++) { // 遍历记录，采用前缀和的思想
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					int geshu_1 = jilu.get(i).get(0);
					int geshu_2 = jilu.get(i).get(1);

					if (geshu_1 >= geshu_2) {
						sum += 1;
					} else {
						sum += 2;
					}
				} else if (j == i) {
					sum += shuzu.get(i);
				} else {
					int geshu_1 = jilu.get(i).get(0) - jilu.get(j - 1).get(0);
					int geshu_2 = jilu.get(i).get(1) - jilu.get(j - 1).get(1);

					if (geshu_1 >= geshu_2) {
						sum += 1;
					} else {
						sum += 2;
					}
				}
			}
		}

		System.out.println(sum);
	}
}