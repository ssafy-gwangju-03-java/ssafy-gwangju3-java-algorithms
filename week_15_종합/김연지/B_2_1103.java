package study_week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2_1103 {
	static int n,m;
	static int hole = -99;
	static int max = -1;
	static boolean flag = false;
	static int [][]map,dp;
	static boolean[][]visited;
	static int[]dr = {1,-1,0,0};
	static int[]dc = {0,0,1,-1};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String [] line = br.readLine().split("");
			for(int j = 0; j < line.length;j++) {
				if(line[j].equals("H")) {
					map[i][j] = hole;
				}else {
					int num = Integer.parseInt(line[j]);
					map[i][j] = num;
				}
			}
		}
		visited[0][0] = true;
		dfs(0,0,1);
		if(flag) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}

	}
	static void dfs(int r, int c, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		dp[r][c] = cnt;
		for(int i = 0; i < 4; i++) {
			int move = map[r][c];
			int nr = r + (move*dr[i]);
			int nc = c + (move*dc[i]);
			
			if(nr < 0 || nc < 0 || nr > n-1 || nc > m-1 || map[nr][nc] == hole) {
				continue;
			}
			if(visited[nr][nc]) {
				flag = true;
				return;
			}
			
			if(dp[nr][nc] > cnt) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1);
			visited[nr][nc] = false;
		}
	}

}
