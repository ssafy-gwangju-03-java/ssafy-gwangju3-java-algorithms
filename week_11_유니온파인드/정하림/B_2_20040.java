import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2_20040 {
    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findSet(a) == findSet(b)) {
                ans = i;
                break;
            }
            unionSet(a, b);

        }
        System.out.println(ans);


    }

    static void unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) return;

        p[pb] = p[pa];
    }

    static int findSet(int a) {
        if (p[a] == a) return a;
        return p[a] = findSet(p[a]);
    }


}
