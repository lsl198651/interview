package others;

import java.util.HashSet;
import java.util.Set;

public class main {
	public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("pwwkew"));
		}

		public static int lengthOfLongestSubstring(String s) {
			int l = s.length(), maxLength = 0, sLength = 1;
			Set<Character> occ = new HashSet<Character>();
			// int maxLength=0;
			if (s.length() == 1) {
				return 1;
			}

			for (int i = 0; i < l - 1; i++) {
				occ.add(s.charAt(i));
				sLength = 1;
				while (!occ.contains(s.charAt(i + sLength)) && sLength <= l - i -1) {
					occ.add(s.charAt(i + sLength));
					sLength++;
				}
				occ.clear();
				if (sLength > maxLength) {
					maxLength = sLength;
				}
			}
			return maxLength;
		}

}