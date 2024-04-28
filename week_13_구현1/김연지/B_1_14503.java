package study_week13;

import java.util.Scanner;

public class B_1_14503 {
	static int n,m,r,c,d;
	static int [][] arr;
	static int cnt = 0;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		find(r,c,d);
		System.out.println(cnt+1);

	}
	static void find(int r, int c, int d) {
		arr[r][c] = -1;
		for(int i = 0; i < 4; i++) {
			d = (d+3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
				if(arr[nr][nc]==0) {
					cnt++;
					find(nr,nc,d);
					return;
				}
			}
		}
		int dir = (d+2) % 4;
		int br = r + dr[dir];
		int bc = c + dc[dir];
		if(br >= 0 && bc >= 0 && br < n && bc < m && arr[br][bc] != 1) {
			find(br,bc,d);
		}
	}

}
