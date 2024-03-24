import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4_1806 {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_08_투포인터/최재원/input.txt"));

        saveInput();

        int p1 = 0;
        int p2 = 0;

        int sum = 0;
        int minLength = N + 1;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(p2-p1, minLength);
                sum -= arr[p1];
                p1 += 1;
            } else if (p2 == N) {
                break;
            } else {
                sum += arr[p2];
                p2 += 1;
            }
        }

        System.out.println(minLength == N + 1 ? 0 : minLength);
    }



    static void saveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
