package week_07_완전탐색.김가람;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ingredient = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            ingredient[i] = new int[]{s, b};
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << N); i++) {
            int s = 1;      // 신맛
            int b = 0;      // 쓴맛
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == (1 << j)) {
                    int[] curr = ingredient[j];
                    s *= curr[0];
                    b += curr[1];
                }
            }
            ans = Math.min(ans, Math.abs(s - b));
        }
        System.out.println(ans);
    }
}
