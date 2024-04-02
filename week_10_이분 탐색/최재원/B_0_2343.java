import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_0_2343 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분 탐색/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int right = 0;
        int left = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        while (left <= right) {
            int m = (left + right) / 2;

            int bundle = 0;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (temp + arr[i] > m) {
                    bundle += 1;
                    temp = 0;
                }

                temp += arr[i];
            }

            if (temp != 0) {
                bundle += 1;
            }

            if (bundle > M) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        System.out.println(left);
        br.close();
    }
}
