package java_study.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4_11724 {
    static int N, M, u, v;
    static int[][] adjm;
    static int[] visited;

    public static void dfs(int i) {
        for (int j = 1; j < N+1; j++) {
            if (adjm[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjm = new int[N+1][N+1];
        visited = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adjm[u][v] = 1;
            adjm[v][u] = 1;
        }

        int cnt = 0;
        for (int i = 1; i < N+1; i++) {
            if (visited[i] == 0){
                visited[i] =1;
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);


    }
}
