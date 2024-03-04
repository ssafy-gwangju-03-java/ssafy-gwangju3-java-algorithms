package study_week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4_2206 {
    static int n, m;
    static int[][] map;
    static int[]dr = {-1,1,0,0};
    static int[]dc = {0,0,-1,1};
//    static boolean[][][]visited = new boolean[2][n][m];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        if(n==1 && m==1) {
        	System.out.println(1);
        }else {
        	System.out.println(bfs());
        }
    }

    public static int bfs(){
    	int [][][] visited = new int[2][n][m];
    	Queue<int[]>q = new ArrayDeque<>();
    	q.add(new int[] {0,0,0});
    	visited[0][0][0] = 1;
    	
    	while(true) {
    		int[]poll = q.poll();
    		if(poll == null) {
    			return -1;
    		}
    		int w = poll[0]; // 벽 부쉈는지 아닌지 확인
    		int r = poll[1];
    		int c = poll[2];
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = r + dr[d];
    			int nc = c + dc[d];
    			if(nr>=0 && nr < n && nc >=0 && nc < m) {
    				
    				if(w == 0) {
    					if(map[nr][nc] == 0 && visited[0][nr][nc]== 0) {
    						q.add(new int[] {0,nr,nc});
    						visited[0][nr][nc] = visited[0][r][c]+1;
    					} else if(map[nr][nc]==1 && visited[0][nr][nc]==0) {
    						if(visited[1][nr][nc]==0) {
    							q.add(new int[] {1,nr,nc});
    							visited[1][nr][nc] = visited[0][r][c] + 1;
    						}
    					}
    				}else {
    					if(map[nr][nc]==0) {
    						if(visited[1][nr][nc]==0) {
    							q.add(new int[] {1,nr,nc});
    							visited[1][nr][nc] = visited[1][r][c] + 1;
    						}
    					}
    				}
    				if(nr == n-1 && nc == m-1) {
    					return Math.max(visited[0][nr][nc], visited[1][nr][nc]);
    				}
    				
    			}
    		}
    	}
    	
    }


}