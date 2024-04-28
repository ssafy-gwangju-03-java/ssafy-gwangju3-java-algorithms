package study_week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3_17135 {
	static int n, m, d;
	static int[][]map;
	static int max = Integer.MIN_VALUE;
	static int[]choice = new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pick(0,0);
		System.out.println(max);

	}
	
	static void pick(int cnt, int start) {
		if(cnt == 3) {
			max = Math.max(max, game());
			return;
		}
		for(int i = start; i < m; i++) {
			choice[cnt] = i;
			pick(cnt+1,i+1);
		}
	}
	
	static int game() {
		int count = 0;
		int[][]status = new int [n][m];
		
		for(int i = n; i > 0; i--) {
			for(int pick:choice) {
				for(int dir = 1; dir <= d; dir++) {
					int cnt = attack(status,dir,i,pick);
					if(cnt < 0) continue;
					count += cnt;
					break;
				}
			}
		}
		return count;
	}
	
	static int attack(int[][]status, int dir, int l, int p) {
		int nr = 0;
		for(int nc = p - dir; nc <= p+dir; nc++) {
			nr = l - (dir-Math.abs(nc-p));
			if(nr < 0 || nr >= l|| nc <0 || nc >= m) continue;
			if(map[nr][nc]==0) continue;
			if(status[nr][nc]==0) {
				status[nr][nc] = l;
				return 1;
			} else if(status[nr][nc]==l){
				return 0;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	

}
