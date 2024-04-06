package week_10_이분탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long l = 1;
        long r = K;

        // K번째 수 X
        // X보다 작거나 같은 수는 최소 K개 있어야 한다
        while (l < r) {
            long m = (l + r) / 2;
            long cnt = 0;

            // i번째 행에서 X보다 작은 원소의 개수 == 최대 N개, 최소 (m / i)개
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(m / i, N);
            }

            // Lower Bound
            if (K <= cnt) r = m;
            else l = m + 1;
        }

        System.out.println(l);
    }
}
