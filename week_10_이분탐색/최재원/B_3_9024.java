import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_9024 {
    static int n, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            sb.append(binarySearch()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int binarySearch() {
        int idx = 0;

        int gap = (int) 1e8 * 2;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int num = arr[idx];
            int left = idx + 1;
            int right = n - 1;

            while (left <= right) {
                int middle = (left + right) / 2;
                int sum = num + arr[middle];
                int current_gap = sum - K;

                if (Math.abs(current_gap) < gap) {
                    gap = Math.abs(current_gap);
                    count = 1;
                } else if (Math.abs(current_gap) == gap) {
                    count += 1;
                }

                if (current_gap > 0) {
                    right = middle - 1;
                } else if (current_gap < 0) {
                    left = middle + 1;
                } else {
                    break;
                }
            }

            idx += 1;
        }

        return count;
    }
}
