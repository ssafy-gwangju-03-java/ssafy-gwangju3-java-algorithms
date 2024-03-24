package week_08_투포인터.전기철;

import java.util.Arrays;
import java.util.Scanner;

public class B_2_1253 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] lst = new int[n];
		String[] s = sc.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			lst[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(lst);
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int k = lst[i];
			int start = 0;
			int end = n - 1;

			while (start < end) {
				int sm = lst[start] + lst[end];
				if (sm == k) {
					if (start != i && end != i) {
						cnt += 1;
						break;
					} else if (start != i && end == i) {
						end -= 1;
						if (lst[start] + lst[end] == k && start < end) {
							cnt += 1;
							break;
						}
					} else {
						start += 1;
						if (lst[start] + lst[end] == k && start < end) {
							cnt += 1;
							break;
						}
					}
				}
				sm = lst[start] + lst[end];
				if (sm > k) {
					end -= 1;
				} else {
					start += 1;
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}
