import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_05_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        s = Arrays.stream(s).sorted().toArray();

        int n = Integer.parseInt(br.readLine());

        int a = 1;
        int b = 0;
        int perfectZone = 0;
        boolean hasAns = true;

        if (n < s[0]) {
            b = s[0] - 1;
        } else {
            for (int i = 0; i < l - 1; i++) {
                if (s[i] == n) {
                    hasAns = false;
                    break;
                }
                if (s[i] < n && n < s[i + 1]) {
                    a = s[i] + 1;
                    b = s[i + 1] - 1;
                }
            }
        }

        if (b == 0) {
            hasAns = false;
        }

        for (int i = a; i <= n; i++) {
            for (int j = n; j <= b; j++) {
                perfectZone += 1;
            }
        }

        if (hasAns) {
            System.out.println(perfectZone - 1);
        } else {
            System.out.println(0);
        }
    }
}
