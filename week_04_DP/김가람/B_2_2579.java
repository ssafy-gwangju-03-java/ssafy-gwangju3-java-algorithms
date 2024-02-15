import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[n+2];
        int[] dp = new int[n+2];

        for (int i = 0; i < n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = step[0];
        dp[1] = step[0] + step[1];
        dp[2] = Math.max(step[0]+step[2], step[1]+step[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]);
        }

        System.out.println(dp[n-1]);
    }
}
