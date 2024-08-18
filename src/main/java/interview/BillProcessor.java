package interview;
//美在美团商城升了个商铺，商铺里有3天货物：A/B/C，但是小美有以下规定：
//		1.每个顾客必须且只能买一个A类货物
//		2.每个顾密只能买最多5个B或者C类货物
//现在小美有很多账单，现在要发你根据上述规定过滤这些账单
//输入描述
//		第1行输入一个整数N。
//		接下来N行，每行输入：用户名,货物种类
//输出描述
//		按照账户的字典序输出
//		如果这个账户没有买A类货物，输出：用户名,invalid
//		如果这个账户超过了人B个你物的购买教量，则个输出多余的购买数量，其体见样例
//		如果这个账户都没有超过了A/B/C货物的购买数量，则输出购买数量，如:0,0,0，量体见样例
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

//class BillProcessor {
//
//	static class Bill {
//		String username;
//		List<Character> items;
//
//		Bill(String username) {
//			this.username = username;
//			this.items = new ArrayList<>();
//		}
//
//		void addItem(char item) {
//			items.add(item);
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		int N = Integer.parseInt(scanner.nextLine());
//		Map<String, Bill> bills = new HashMap<>();
//
//		for (int i = 0; i < N; i++) {
//			String[] input = scanner.nextLine().split(",");
//			String username = input[0];
//			char item = input[1].charAt(0);
//
//			bills.putIfAbsent(username, new Bill(username));
//			bills.get(username).addItem(item);
//		}
//
//		List<String> sortedUsernames = new ArrayList<>(bills.keySet());
//		Collections.sort(sortedUsernames);
//
//		for (String username : sortedUsernames) {
//			Bill bill = bills.get(username);
//			Map<Character, Integer> itemCounts = new HashMap<>();
//			itemCounts.put('A', 0);
//			itemCounts.put('B', 0);
//			itemCounts.put('C', 0);
//
//			for (char item : bill.items) {
//				itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
//			}
//
//			int countA = itemCounts.get('A');
//			int countB = itemCounts.get('B');
//			int countC = itemCounts.get('C');
//
//			if (countA != 1) {
//				System.out.println(username + ",invalid");
//			} else if (countB + countC > 5) {
//				int extraItems = countB + countC - 5;
//				System.out.println(username + "," + extraItems);
//			} else {
//				System.out.println(username + ",0,0,0");
//			}
//		}
//
//		scanner.close();
//	}
//}
import java.util.*;

class BillProcessor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = Integer.parseInt(scanner.nextLine());
		Map<String, Bill> bills = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String[] input = scanner.nextLine().split(",");
			String username = input[0];
			char item = input[1].charAt(0);

			bills.putIfAbsent(username, new Bill(username));
			bills.get(username).addItem(item);
		}

		List<String> sortedUsernames = new ArrayList<>(bills.keySet());
		Collections.sort(sortedUsernames);

		for (String username : sortedUsernames) {
			Bill bill = bills.get(username);
			Map<Character, Integer> itemCounts = new HashMap<>();
			itemCounts.put('a', 0);
			itemCounts.put('b', 0);
			itemCounts.put('c', 0);

			for (char item : bill.items) {
				itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
			}

			int countA = itemCounts.get('a');
			int countB = itemCounts.get('b');
			int countC = itemCounts.get('c');

			if (countA != 1) {
				System.out.println(username + ",invalid");
			} else {
				int totalBC = countB + countC;
				if (totalBC > 5) {
					System.out.println(username + "," + countA + "," + countB + "," + countC + "," + (totalBC - 5));
				} else {
					System.out.println(username + "," + countA + "," + countB + "," + countC );
				}
			}
		}

		scanner.close();
	}

	static class Bill {
		String username;
		List<Character> items;

		Bill(String username) {
			this.username = username;
			this.items = new ArrayList<>();
		}

		void addItem(char item) {
			items.add(item);
		}
	}
}




