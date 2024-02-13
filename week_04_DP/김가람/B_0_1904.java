package week_04_DP.김가람;

import java.util.Scanner;

public class B_0_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tile = new int[n+1];

        tile[0] = 1;
        tile[1] = 2;

        for (int i = 2; i < n; i++) {
            tile[i] = (tile[i-2] + tile[i-1]) % 15746;
        }

        System.out.println(tile[n-1]);
    }
}
