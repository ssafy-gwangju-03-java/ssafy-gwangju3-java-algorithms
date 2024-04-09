import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_0_17352 {
    static int N;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        p = makeSet();

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 0; i < N + 1; i++) {
            findSet(i);
        }

        int start = p[1];
        int end = 0;
        for (int i = 1; i < N + 1; i++) {
            if (p[i] != start) {
                end = p[i];
                break;
            }
        }

        System.out.println(start + " " + end);
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
        int[] arr = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        return arr;
    }
}
