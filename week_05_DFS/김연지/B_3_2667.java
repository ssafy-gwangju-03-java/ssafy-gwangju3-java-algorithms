package study_week5;

import java.util.Arrays;
import java.util.Scanner;

public class B_3_2667 {
	static int [][] map;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int cnt = 0;
	static int num = 2;
	static int n;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			String [] temp = sc.nextLine().split("");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j]==1) {
					dfs(i,j);
					cnt++;
					num++;
				}
			}
		}
		System.out.println(cnt);
		int [] result = new int [num-1];
		for(int i = 2; i <= num; i++) {
			int total = 0;
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					if(map[a][b]==i) {
						total++;
					}
				}
			}
			result[i-2] = total;
		}
		Arrays.sort(result);
		for(int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	}
	public static void dfs(int r, int c) {
		map[r][c] = num;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<n && nc>=0 && nc < n && map[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}

}
