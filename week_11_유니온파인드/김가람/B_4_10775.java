package 김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4_10775 {
    static int G;
    static int P;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }
        P = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int curr = Integer.parseInt(br.readLine());
            int emptyGate = find(curr);

            if (emptyGate == 0) break;

            union(emptyGate - 1, emptyGate);
            ans++;
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }
}


