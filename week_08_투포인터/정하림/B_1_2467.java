package java_study.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_2467 {
    static int N;
    static int[] liquid;
    static int min;
    static int s1, s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        liquid = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        min = Math.abs(liquid[0] + liquid[N - 1]);
        s1 = 0;
        s2 = N - 1;
        ish(0,N-1);
        System.out.printf("%d %d", liquid[s1], liquid[s2]);
    }

    public static void ish(int l, int r) {
        if (l == r) return;

        if (Math.abs(liquid[l] + liquid[r]) <= min) {
            min = Math.abs(liquid[l] + liquid[r]);
            s1 = l;
            s2 = r;
        }
        if (liquid[l] + liquid[r] > 0) {
            ish(l, r-1);
            return;
        }
        if (liquid[l] + liquid[r] < 0) {
            ish(l+1, r);
            return;
        }
        if (liquid[l] + liquid[r] == 0) {
            return;
        }

    }
}
