import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_1253 {
    static int N;
    static int[] arr;

    static int count;

    public static void main(String[] args) throws IOException {
        saveInput();

        solution();

        System.out.println(count);
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            int target = arr[i];

            int p1 = 0;
            int p2 = N - 1;

            while (p1 != p2) {

                if (p1 == i) {
                    p1 += 1;
                    continue;
                } else if (p2 == i) {
                    p2 -= 1;
                    continue;
                }

                int sum = arr[p1] + arr[p2];

                if (sum == target) {
                    count += 1;
                    break;
                } else if (sum > target) {
                    p2 -= 1;
                } else {
                    p1 += 1;
                }

            }
        }

    }

    static void saveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        br.close();
    }
}
