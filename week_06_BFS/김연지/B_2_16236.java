package study_week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2_16236 {

	public static void main(String[] args) {

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] sea = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sea[i][j] = sc.nextInt();
			}
		}
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (sea[i][j] == 9) {
					q.add(new int[] { i, j });
				}
			}

		}
		int fish = 2;
		int eat = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int r = t[0];
			int c = t[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (sea[nr][nc] < fish) {
						eat += 1;
						if(eat == fish) {
							fish += 1;
							eat = 0;
						}
						else {
							break;
						}
						cnt ++;
						q.add(new int[] { nr, nc });
					} else if (sea[nr][nc] == fish) {
						q.add(new int[] { nr, nc });
						cnt++;
					}
				}
			}

		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sea[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(cnt);
		

	}

}
