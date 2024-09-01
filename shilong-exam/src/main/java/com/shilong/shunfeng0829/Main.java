package com.shilong.shunfeng0829;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		for (int i = 0; i < n; i++) {
			String functionName = scanner.nextLine();
			String result = convertFunctionName(functionName);
			System.out.println(result);
		}

		scanner.close();
	}

	private static String convertFunctionName(String functionName) {
		if (isCamelCase(functionName)) {
			return convertCamelToUnderscore(functionName);
		} else if (isUnderscoreCase(functionName)) {
			return functionName;
		} else {
			return "indistinct";
		}
	}

	private static boolean isCamelCase(String functionName) {
		return functionName.matches("^[a-z]+([A-Z][a-z]*)*$");
	}

	private static boolean isUnderscoreCase(String functionName) {
		return functionName.matches("^[a-z]+(_[a-z]+)*$");
	}

	private static String convertCamelToUnderscore(String camelCase) {
		return camelCase.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toLowerCase();
	}
}