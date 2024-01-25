package W1;

import java.util.Scanner;

public class B_29_2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] NM = new int[N * M];
        int nm;
        for (int idx = 0; idx < (N * M); idx++) {
            nm = sc.nextInt();
            NM[idx] = nm;
        }
        for (int idx = 0; idx < (N * M); idx++) {
            nm = sc.nextInt();
            NM[idx] += nm;
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (m == (M - 1)) {
                    System.out.println(NM[(n * M) + m]);
                } else {
                    System.out.printf("%d ", NM[(n * M) + m]);
                }

            }
        }
    }
}
