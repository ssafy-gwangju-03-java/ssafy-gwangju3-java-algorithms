package week_11_유니온파인드.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2_20040 {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            // u, v의 대표자가 같을 때 (사이클을 형성할 때) union 함수는 false를 반환
            if (!union(u, v)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        // 부모가 같다 == 사이클 형성
        if (x == y) return false;

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return true;
    }
}


