import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_00_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < N + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N - 1]);
    }
}
