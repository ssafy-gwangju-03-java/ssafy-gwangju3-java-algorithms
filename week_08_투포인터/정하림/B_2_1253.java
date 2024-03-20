package java_study.w8;

import java.io.*;
import java.util.*;

public class B_2_1253 {
    static int N;
    static int[] A;
    static int[] selected;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        selected = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        two(0, 1);
        System.out.println(cnt);

    }

    public static void two(int l, int r) {
        if (l == N - 1) return;
        if (r == N) {
            two(l + 1, l + 2);
            return;
        }
        int a = A[l] + A[r];

        for (int i = 0; i < N; i++) {
            if (A[i] == a && selected[i] == 0 && i != l && i != r) {
                selected[i] = 1;
                cnt++;
            }
        }
        two(l, r+1);

    }
}
