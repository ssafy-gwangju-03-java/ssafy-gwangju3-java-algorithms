package study_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_5_1941 {
	
	static char[][]map = new char[5][5];
	static boolean[][]visited = new boolean[5][5];
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0,0);
		System.out.println(cnt);

	}
	static void dfs(int depth, int start) {
		if(depth == 7) {
			if(check()) cnt++;
		}else {
			for(int i = start; i < 25; i++) {
				visited[i/5][i%5] = true;
				dfs(depth+1, i+1);
				visited[i/5][i%5] = false;
			}
		}
	}
	
	static boolean check() {
		boolean[][] vs = new boolean[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				vs[i][j] = visited[i][j];
			}
		}
		int a = 0;
		int b = 0;
		for(int i=0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(vs[i][j]) {
					a = i;
					b = j;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int [] {a,b});
		int count = 0;
		int s = 0;
		while(!q.isEmpty()) {
			int[]temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 > nr || 5<= nr || 0>nc || 5<= nc) continue;
				
				if(vs[nr][nc]) {
					if(map[nr][nc] == 'S') s++;
					count++;
					q.add(new int[] {nr,nc});
					vs[nr][nc] = false;
				}
			}
		}
		if(count == 7 && s>=4) {
			return true;
		}
		return false;
	}

}
