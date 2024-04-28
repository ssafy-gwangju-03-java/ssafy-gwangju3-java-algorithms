package study_week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_2_11559 {
	static char[][]map = new char[12][6];
	static int cnt = 0;
	static int[]dr = {0,0,-1,1};
	static int[]dc = {1,-1,0,0};
	static boolean check = false;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		for(int i = 0; i < 12; i++) {
//			st = new StringTokenizer(br.readLine());
			String temp = br.readLine();
			for(int j = 0; j < 6; j++) {
				map[i][j] = temp.charAt(j);
			}
			
		}
		
		while(true) {
			check = false;
			puyo();
			toFloor();
			
			if(check == false) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);

	}
	static class node{
		int x,y;
		char color;
		node(int x, int y, char color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	static void puyo() {
		Queue<node> q = new LinkedList<>();
		boolean[][]visited = new boolean[12][6];
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(map[i][j] != '.' && !visited[i][j]) {
					ArrayList<int[]>lst = new ArrayList<>();
					q.add(new node(i,j,map[i][j]));
					lst.add(new int [] {i,j});
					visited[i][j] = true;
					while(!q.isEmpty()) {
						node p = q.poll();
						int curr = p.x;
						int curc = p.y;
						char curC = p.color;
						for(int t = 0; t < 4; t++) {
							int nr = curr + dr[t];
							int nc = curc + dc[t];
							
							if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
							
							if(!visited[nr][nc] && map[nr][nc] == curC) {
								q.add(new node(nr,nc,map[nr][nc]));
								lst.add(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						}
					}
					
					if(lst.size() >= 4) {
						for(int k = 0; k < lst.size(); k++) {
							int x = lst.get(k)[0];
							int y = lst.get(k)[1];
							
							map[x][y] = '.';
							check = true;
						}
					}
				}
			}
		}
		
	}
	static void toFloor() {
		for(int j = 0; j < 6; j++) {
			down(j);
		}
	}
	
	static void down(int j) {
		Queue<node> q = new LinkedList<>();
		int idx = 11;
	
		for(int i = 11; i >= 0; i--) {
			if(map[i][j] != '.') {
				q.add(new node(i,j,map[i][j]));
				map[i][j] = '.';
			}
		}
		while(!q.isEmpty()) {
			node p = q.poll();
			char color = p.color;
			map[idx][j] = color;
			
			idx--;
		}
	
	
	}

	
	
	
}
