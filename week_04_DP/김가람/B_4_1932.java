package week_04_DP.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(tri[0][0]);
        } else {
            int[][] sums = new int[N][N];

            for (int i = N - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    if (i == N - 2) {
                        sums[i][j] = Math.max(tri[i][j]+tri[i+1][j], tri[i][j]+tri[i+1][j+1]);
                    } else {
                        sums[i][j] = Math.max(tri[i][j]+sums[i+1][j], tri[i][j]+sums[i+1][j+1]);
                    }
                }
            }

            System.out.println(sums[0][0]);
        }
    }
}

