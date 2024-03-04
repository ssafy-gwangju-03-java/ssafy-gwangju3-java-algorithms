package study_week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3_14502 {
	static int n,m;
	static int[][]map;
	static int[][]virusMap;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		
//
//	}
	
		
	}
	// 벽세우기 : 3개 세우면 return
	public static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 바이러스 퍼뜨리기 - bfs
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 벽이 세개 세워질때마다 맵 초기화
		virusMap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				virusMap[i][j] = map[i][j];
				if(virusMap[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		
		
		while(!q.isEmpty()) {
			int [] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr < n && nc>=0 && nc < m && virusMap[nr][nc] == 0) {
					virusMap[nr][nc] = 2;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(virusMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}

}
