import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B_00_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] pascal = new int[n + 1][n + 1];

        pascal[0][0] = 1;
        pascal[1][0] = 1;
        pascal[1][1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j - 1 < 0) {
                    pascal[i][j] = pascal[i - 1][j];
                    continue;
                }

                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        System.out.println(pascal[n - 1][k - 1]);
    }
}
