package java_study.w7;

import java.util.*;
import java.lang.*;

public class B_0_9663 {
    static int N;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        nQueen(0);
        System.out.println(cnt);

    }
    public static void nQueen(int nowr) {
        if (nowr == N) {
            cnt++;
            return;
        }

        for (int nowc = 0; nowc < N; nowc++) {
            boolean can = true;

            for (int nr = 0; nr < nowr; nr++) {
                if (nowc == arr[nr] || (nowr - nr) == Math.abs(arr[nr] - nowc)) {
                    can = false;
                    break;
                }
            }
            if (can) {
                arr[nowr] = nowc;
                nQueen(nowr + 1);
            }

        }
    }
}