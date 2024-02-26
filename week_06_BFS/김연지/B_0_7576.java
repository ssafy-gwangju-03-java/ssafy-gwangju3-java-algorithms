package study_week6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B_0_7576 {
	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	static int[][]visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] temp = sc.nextLine().split(" ");
		int m = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		int[][]arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String [] s = sc.nextLine().split(" ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 없는 칸 
//		int day = 0;
//		visited = new int[n][m];
		Queue<int[]>q = new ArrayDeque<>();
		int r = 0;
		int c = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]==1) {
					q.add(new int[] {i,j});
//					r = i;
//					c = j;
				}
			}
		}
//		int cnt = 0;
//		visited[r][c] = 1;
//		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int [] poll = q.poll();
			r = poll[0];
			c = poll[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=0 && nr < n && nc>=0 && nc < m && arr[nr][nc]==0) {
//					arr[nr][nc] = 1;
					arr[nr][nc] = arr[r][c] + 1;
					q.add(new int[] {nr,nc});
				}
			}
		}
		int max = 0;
		int result = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					max = 0;
					result = 0;
					break;
				}else {
					if(arr[i][j]>max) {
						max = arr[i][j];
					}
				}
			}
			if(result == 0) {
				break;
			}
		}
		
		System.out.println(max-1);
		
		
	}

}
