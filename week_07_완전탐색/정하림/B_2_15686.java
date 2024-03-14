package java_study.w7;

import java.io.*;
import java.util.*;
import java.lang.*;

public class B_2_15686 {
    static int N, M;
    static int[][] city;
    static int cnt_H = 0, cnt_C = 0;
    static List<int[]> rc_H = new ArrayList<>();
    static List<int[]> rc_C = new ArrayList<>();
    static int D = 1300;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    cnt_H++;
                    rc_H.add(new int[]{i,j});
                } else if (city[i][j] == 2) {
                    cnt_C++;
                    rc_C.add(new int[]{i,j});
                }
            }
        }
        sel = new int[cnt_C];
        survive(0,0);
        System.out.println(D);
    }

    public static void survive(int n, int r) {
        if (r == M) {
            D = Math.min(D, calc(sel));
            return;
        }
        if (n == cnt_C) {
            return;
        }
        sel[n] = 1;
        survive(n+1,r+1);
        sel[n] = 0;
        survive(n+1, r);
    }

    public static int calc(int[] sel) {
        int d_total = 0;
        for (int i = 0; i < cnt_H; i++) {
            int d = 2*50;
            int[] rHcH = rc_H.get(i);
            int rH = rHcH[0], cH = rHcH[1];
            for (int j = 0; j < cnt_C; j++) {
                if (sel[j] == 1) {
                    int[] rCcC = rc_C.get(j);
                    int rC = rCcC[0], cC = rCcC[1];
                    d = Math.min(d, (Math.abs(rH - rC) + Math.abs(cH - cC)));

                }
            }
            d_total += d;

        }
        return d_total;
    }
}
