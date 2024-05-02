package leetCode;

import java.util.*;

public class lc49 {
  public static void main(String[] args) {
    String[] strs = new String[6];
    strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
	Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
		char[] array = str.toCharArray();
		Arrays.sort(array);// 转为字符数组并排序
		String key = new String(array);
		List<String> list = map.getOrDefault(key, new ArrayList<String>());
		list.add(str);
		map.put(key, list);

    }
	  System.out.println(new ArrayList<List<String>>(map.values()));

		}
}
