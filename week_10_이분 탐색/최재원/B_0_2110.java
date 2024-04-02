import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_0_2110 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분 탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1];

        while (left <= right) {
            int middle = (left + right) / 2;

            int idx = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                if (arr[i] - arr[idx] >= middle) {
                    idx = i;
                    count += 1;
                }
            }

            if (count >= C) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        System.out.println(left - 1);
    }
}
