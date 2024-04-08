package week_11_유니온파인드.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_1717 {
    static int N;
    static int M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int op = Integer.parseInt(temp[0]);
            int a = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);
            if (op == 1) {
                System.out.println((find(a) == find(b)) ? "YES" : "NO");
            } else {
                union(a, b);
            }
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        parent[x] = y;
    }
}
