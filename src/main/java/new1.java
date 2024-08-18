import java.util.Arrays;


public class new1 {
	public static void main(String[] args){
//		就这样写
//		左边是思路
//运行，复制，刷新一下，

//		你问问面试官这个怎么运行不了
//				okkk
//	定义了两个字符串s1和s2，以及两个整数n和m分别表示它们的长度。
		String s1 = "ab";
		String s2 = "eidbaooo";

				int n = s1.length(), m = s2.length();
//	如果s1的长度大于s2的长度，则直接输出false，因为s1的任何排列都不可能是s2的子串。
				if (n > m) {
					System.out.println(false);
				}
//	定义了两个长度为26的整型数组cnt1和cnt2，分别用于统计字符串s1和s2中每个字符出现的次数。这里假设字符串只包含小写字母
				int[] cnt1 = new int[26];
				int[] cnt2 = new int[26];
//	遍历字符串s1和s2的前n个字符，统计它们的字符出现次数，并存储在数组cnt1和cnt2中。
				for (int i = 0; i < n; ++i) {
					++cnt1[s1.charAt(i) - 'a'];
					++cnt2[s2.charAt(i) - 'a'];
				}
//	如果数组cnt1和cnt2相等，说明s1的排列之一是s2的子串，输出true。
				if (Arrays.equals(cnt1, cnt2)) {
					System.out.println(true);
				}
//	遍历字符串s2的剩余部分，每次移动一个字符的长度，更新cnt2数组，同时比较cnt1和cnt2数组是否相等。如果相等，则输出true。
				for (int i = n; i < m; ++i) {
					++cnt2[s2.charAt(i) - 'a'];
					--cnt2[s2.charAt(i - n) - 'a'];
					if (Arrays.equals(cnt1, cnt2)) {
						System.out.println(true);
					}
				}
//	如果以上条件都不满足，则输出false，表示s2不包含s1的任何排列作为子串。
		System.out.println(false);


	}
}
