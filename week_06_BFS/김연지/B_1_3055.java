package study_week6;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1_3055 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static String[][]map;
    static int answer;
    static int r,c;
    static int n,m;
    static int flag;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	if (map[i][j].equals("S")) {
            		q.add(new int[]{i, j,0});
            	}
            	else if (map[i][j].equals("*")) {
                    water.add(new int[]{i, j});
                }
            }
        }
        
        answer = 100000;
        
        flag = 0;

        bfs();
        if (flag == 1) {
        	System.out.println(answer);
        }else {
        	System.out.println("KAKTUS");
        }

    }
    
    public static void bfs() {
    	while(!q.isEmpty()) {
    		
    		// for문에 바로 water.size() 사용하면 오답인 이유??
    		int len = water.size();
    		for(int i = 0; i < len; i++) {
    			int[]t = water.poll();
    			int x = t[0];
    			int y = t[1];
    			for (int d = 0; d < 4; d++) {
                    int nr = x + dr[d];
                    int nc = y + dc[d];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc].equals(".")) {
                        map[nr][nc] = "*";
                        water.add(new int[]{nr, nc});
                    }
                }
    		}
    		len = q.size();
    		for(int i = 0; i < len; i++) {
    			int [] t = q.poll();
    			int x = t[0];
    			int y = t[1];
    			int time = t[2];
    			for (int d = 0; d < 4; d++) {
    				int nr = x + dr[d];
    				int nc = y + dc[d];
    				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
    					if(map[nr][nc].equals("D")) {
    						answer = Math.min(answer, time+1);
    						flag = 1;
    						return;
    					}else if(map[nr][nc].equals(".")) {
    						map[nr][nc] = "S";
    						q.add(new int[] {nr,nc,time+1});
    					}
    					
    				}
    			}
    		}
    	}
    }
    
}