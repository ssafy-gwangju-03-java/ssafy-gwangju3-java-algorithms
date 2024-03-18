import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_0_2531 {
    static int N, d, k, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_08_투포인터/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int j = k - 1;

        int max_v = 0;

        int[] dishes = new int[k];

        for (int t = 0; t < N + k - 1; t++) {
            Set<Integer> set = new HashSet<>();
            set.add(c);

            dishes[i] = arr[j];

            if (t >= k) {
                for (int l = 0; l < k; l++) {
                    set.add(dishes[l]);
                }
            }

            max_v = Math.max(set.size(), max_v);

            i = (i + 1) % k;
            j = (j + 1) % N;
        }

        System.out.println(max_v);
    }
}
