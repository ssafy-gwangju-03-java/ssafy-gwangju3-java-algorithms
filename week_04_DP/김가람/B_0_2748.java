package week_04_DP.김가람;

import java.io.IOException;
import java.util.Scanner;

public class B_0_2748 {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long[] fibo = new long[n+1];
            fibo[0] = 1;
            fibo[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
            System.out.println(fibo[n-1]);
        }

}
