package baekjoon;

import java.util.Scanner;

public class B_32_2744 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String sr = sc.next();
		char[] arr = sr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			int num = (int) ch;
			if (num < 97) {
				num += 32;
			} else {
				num -= 32;
			}
			arr[i] = (char) num;

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

}
