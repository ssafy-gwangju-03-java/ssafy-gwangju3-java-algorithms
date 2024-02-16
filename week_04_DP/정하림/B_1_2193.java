package w4;

import java.util.Scanner;

public class B_1_2193 {
    static long[] pinary;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pinary = new long[N+3];
        pinary[0] = 0;
        pinary[1] = 1;//1
        pinary[2] = 1;//10
        pinary[3] = 2;//100 101
        for (int i = 4; i <= N; i++) {
            pinary[i] = pinary[i - 1] + pinary[i - 2];
        }
        System.out.println(pinary[N]);
    }
}
