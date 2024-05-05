package study_week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2_9328 {
	static int n, m, k, t;
	static int ans = 0;
	static int[] arr;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int h = 0;
	static int w = 0;
	static int[][] visited;
	static int key;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < t; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for (int j = 1; j <= w; j++) {
					map[i][j] = temp.charAt(j - 1);
				}
			}

			key = 0;
			st = new StringTokenizer(br.readLine());
			String Key = st.nextToken();
			for (int i = 0; i < Key.length(); i++) {
				key |= (1 << Key.charAt(i) - 'a');
			}
			bfs();
			System.out.println(ans);
		}

	}

	static void bfs() {
		Queue<int[]>q = new LinkedList<>();
		visited = new int[h+2][w+2];
		visited[0][0]=key;
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr > h+1 || nc < 0 || nc > w+1) continue;
				if(map[nr][nc]=='*')continue;
				
				if(visited[nr][nc] == key) continue;
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
					boolean flag = (key & (1<< map[nr][nc] - 'A')) > 0;
					if(flag == false) continue;
			}
			else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
				key |= (1 << map[nr][nc] - 'a');
			}
			else if (map[nr][nc] == '$') {
				ans += 1;
			}
				
				map[nr][nc] = '.';
				visited[nr][nc] = key;
				q.offer(new int[] {nr,nc});
		}
	}
	}
}


