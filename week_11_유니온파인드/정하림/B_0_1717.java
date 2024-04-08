package 정하림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_0_1717 {
    static int n, m;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n+1];
        for (int i = 0; i <= n; i++) p[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int uf = Integer.parseInt(st.nextToken());
            // 0 합집합 / 1 같은집합인지
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (uf == 1) {
//                for (int j = 0; j <= n; j++) {
//                    findSet(j);
//                }
                if (findSet(a) == findSet(b)) System.out.println("YES");
                else System.out.println("NO");
            }
            else unionSet(a,b);
        }
    }
    public static void unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if (pa == pb) return;
        p[pb] = p[pa];
    }
    public static int findSet(int a) {
        if (a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }
}
