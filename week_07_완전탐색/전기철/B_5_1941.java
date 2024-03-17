package week_07_완전탐색.전기철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class B_5_1941 {
 
    static int som = 0, ans[];
    static char map[][];
    static boolean vis[], check[];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static Queue<Integer> q;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        map = new char[5][5];
        for (int i = 0; i < 5; i++) 
            map[i] = br.readLine().toCharArray();
 
        vis = new boolean[5*5];
        ans = new int[7];
        find(0, 0, 0);
        System.out.println(som);
    }
    public static void find(int idx, int cnt, int cntS) {
        if (cnt == 7) {
            if (cntS >= 4) {
                if(link())
                    som++;
                return;
            }
            return;
        }
        
        for (int i = idx; i < 5*5; i++) {
            vis[i] = true;
            ans[cnt] = i;
            if(map[i/5][i%5] == 'S')
            {
                find(i + 1, cnt + 1, cntS + 1);
            }
            else
            {
                find(i + 1, cnt + 1, cntS);
            }
            vis[i] = false;
        }
    }
    
    public static boolean link() {
        int cnt = 1;
        check = new boolean[5*5];
        q = new LinkedList<>();
        q.add(ans[0]);
        while(!q.isEmpty()) {
            int now = q.poll();
            check[now] = true;
            for (int d = 0; d < 4; d++) {
                int nx = (now/5) + dx[d];
                int ny = (now%5) + dy[d];
                if(0<=nx && nx<5 && 0<=ny &&ny<5 && !check[nx*5+ny] && vis[nx*5+ny])
                {
                    cnt++;
                    check[nx*5+ny] = true;
                    q.add(nx*5+ny);
                }
            }
        }
        if(cnt == 7) 
        {
            return true;
        }
        else
        {
            return false;
        }
            
    }
}