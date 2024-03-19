import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_2467 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("week_08_투포인터/최재원/input.txt"));

        saveInput();

        int[] answer = solution();

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] solution() {
        int p1 = 0;
        int p2 = N - 1;

        int value1 = arr[p1];
        int value2 = arr[p2];

        int min_v = Integer.MAX_VALUE;

        while (p1 != p2) {
            int sum = arr[p1] + arr[p2];

            if (Math.abs(sum) <= min_v) {
                min_v = Math.abs(sum);
                value1 = arr[p1];
                value2 = arr[p2];
            }

            if (sum == 0) {
                break;
            }else if (sum < 0) {
                p1 += 1;
            } else{
                p2 -= 1;
            }
        }

        return new int[]{value1, value2};
    }

    static void saveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
