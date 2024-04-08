import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class B_4_7453 {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분탐색/최재원/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] ABCD = new long[N][4];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                ABCD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[] AB = new long[N * N];
        long[] CD = new long[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = ABCD[i][0] + ABCD[j][1];
                CD[i * N + j] = ABCD[i][2] + ABCD[j][3];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;

        for (int i = 0; i < N * N; i++) {
            long curr = AB[i];
            long lowest = lowerBound(CD, -curr);
            long highest = upperBound(CD, -curr);

            answer += (highest - lowest);
        }

        System.out.println(answer);
    }

    static long lowerBound(long[] arr, long target) {
        int l = 0;
        int r = N * N;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    static int upperBound(long[] arr, long target) {
        int l = 0;
        int r = N * N;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}
