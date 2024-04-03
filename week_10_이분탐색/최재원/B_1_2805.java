import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_2805 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = Arrays.stream(arr).max().getAsInt();

        while (left <= right) {
            long middle = (left + right) / 2;

            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > middle) {
                    sum += arr[i] - middle;
                }
            }

            if (sum >= M) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(left - 1);
        br.close();
    }
}
