import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_2961 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());


        int[] S = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int diff = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << N); i++) {
            int sumS = 0;
            int sumB = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    if (sumS == 0) {
                        sumS = S[j];
                    } else {
                        sumS *= S[j];
                    }
                    sumB += B[j];
                }
            }

            int temp = Math.abs(sumS - sumB);

            diff = Math.min(temp, diff);
        }

        System.out.println(diff);
    }
}
