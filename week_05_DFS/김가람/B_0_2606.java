package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_2606 {
    static int[][] network;
    static int v;
    static int infected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        network = new int[v+1][v+1];

        int e = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            String[] temp = br.readLine().split(" ");
            int v1 = Integer.parseInt(temp[0]);
            int v2 = Integer.parseInt(temp[1]);
            network[v1][v2] = 1;
            network[v2][v1] = 1;
        }

        infected = 0;
        dfs(1);
        System.out.println(infected);
    }

    static void dfs(int w) {
        network[w][w] = 1;

        for (int i = 0; i <= v; i++) {
            if (network[w][i] == 1 && network[i][i] != 1) {
                infected++;
                dfs(i);
            }
        }
    }
}