import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_0_1717 {
    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = makeSet();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int calculation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (calculation == 0) {
                union(a, b);
            } else {
                if (findSet(a) == findSet(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    static void union(int a, int b) {
        if (findSet(a) == findSet(b)) {
            return;
        }

        p[findSet(b)] = findSet(a);
    }

    static int findSet(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = findSet(p[x]);
    }


    static int[] makeSet() {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        return arr;
    }
}
