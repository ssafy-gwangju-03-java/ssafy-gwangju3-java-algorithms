package week_04_DP.김가람;

import java.util.Scanner;

public class B_0_16395 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] tri = new int[n+1][n+1];
            tri[0][0] = 1;
            for (int i = 1; i < n; i++) {
                tri[i][0] = 1;
                for (int j = 1; j < n-1; j++) {
                    tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
                }
                tri[i][n-1] = 1;
            }
            System.out.println(tri[n-1][k-1]);
        }
    }

}
