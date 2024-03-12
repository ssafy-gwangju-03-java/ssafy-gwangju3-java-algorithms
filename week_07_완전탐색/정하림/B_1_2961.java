package java_study.w7;

import java.io.*;
import java.lang.*;
import java.util.*;

public class B_1_2961 {
    static int N;
    static int[] S; // 신맛 곱하기
    static int[] C; // 쓴맛 더하기
    static int result = 1000000000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N];
        C = new int[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            S[n] = Integer.parseInt(st.nextToken());
            C[n] = Integer.parseInt(st.nextToken());
        }
        // int i = 1; 재료는 적어도 하나 사용해야 한다.
        for (int i = 1; i < (1 << N); i++) {
            int s = 1;
            int c = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    s *= S[j];
                    c += C[j];
                }
            }
            result = Math.min(result, Math.abs(s - c));
        }
        System.out.println(result);
    }
}
