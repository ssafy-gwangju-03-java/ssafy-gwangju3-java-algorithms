package java_study.w3;

import java.util.Arrays;
import java.util.Scanner;

public class B_5_1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int[] S = new int[L];
        for (int i = 0; i < L; i++) {
            S[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        Arrays.sort(S);

        boolean zero = true;
        if (n < S[0]) { // n < 최소
            System.out.println(n * (S[0] - n) - 1);
        }
        else {
            for (int j = 0; j < (L - 1); j++) {

                if (S[j] < n && n < S[j + 1]) {
                    System.out.println((n - S[j]) * (S[j + 1] - n) - 1);
                    zero = false;
                    break;
                }
            }
        }
        if (zero) { // n = S[idx] or 최대 < n
            System.out.println(0);
        }
    }
}