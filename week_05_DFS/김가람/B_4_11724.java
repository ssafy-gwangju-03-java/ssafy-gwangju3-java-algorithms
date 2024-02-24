package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4_11724 {
    static int[][] graph;
    static int[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(String.valueOf(s[0]));
        M = Integer.parseInt(String.valueOf(s[1]));
        graph = new int[N+1][N+1];
        visited = new int[N+1];


        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int r = Integer.parseInt(String.valueOf(temp[0]));
            int c = Integer.parseInt(String.valueOf(temp[1]));
            graph[r][c] = 1;
            graph[c][r] = 1;
        }

        int cnt = 0;

        for (int i = 1; i < N+1; i++) {
            if (visited[i] == 0) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int n) {
        visited[n] = 1;

        for (int i = 1; i < N + 1; i++) {
            if (graph[n][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}

