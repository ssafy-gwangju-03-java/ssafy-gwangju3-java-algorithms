import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_0_1759 {
    static char[] arr, c, vowel = {'a', 'e', 'i', 'o', 'u'};
    static int L, C;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_07_완전탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        c = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        comb(0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    private static void comb(int idx, int start) {
        if (idx == L) {
            validate_password(c);
            return;
        }

        for (int i = start; i < C; i++) {
            c[idx] = arr[i];
            comb(idx + 1, i + 1);
        }
    }

    private static void validate_password(char[] arr) {
        int vowel_count = 0;

        for (char c : arr) {
            for (char v : vowel) {
                if (c == v) {
                    vowel_count += 1;
                }
            }
        }

        if (vowel_count >= 1 && L - vowel_count >= 2) {
            for (int i = 0; i < L; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
        }
    }
}
