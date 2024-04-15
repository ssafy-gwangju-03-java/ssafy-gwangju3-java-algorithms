package study_week11;

import java.util.Scanner;

public class B_4_10775 {
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int P = sc.nextInt();
		p = new int[G + 1];

		int ans = 0;
		for (int i = 1; i <= G; i++) {
			p[i] = i;
		}

		for (int i = 0; i < P; i++) {
			int g = sc.nextInt();
			int empty = find(g);

			if (empty == 0) {
				break;
			}

			ans++;
			union(empty, empty - 1);
		}

		System.out.println(ans);

	}

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (x != y) {
			p[x] = y;
		}
	}

}
