package java_study.w5;

import java.util.Scanner;

public class B_0_2606 {
    static int[][] graph;
    static int[] visited;
    static int cnt, N, adj;
    public static int dfs(int i) {
        visited[i] = 1;
        for (int j = 1; j < N+1; j++) {
            if (graph[i][j] == 1 && visited[j]==0) {
                cnt++;
                dfs(j);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = sc.nextInt();

        graph = new int[N+1][N+1];
        visited = new int[N + 1];

        int n1, n2;
        for (int i = 0; i < adj ; i++) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }
        System.out.println(dfs(1));
    }
}

