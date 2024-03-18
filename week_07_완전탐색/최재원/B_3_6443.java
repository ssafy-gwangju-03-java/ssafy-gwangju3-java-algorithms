import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_3_6443 {
    static int M;
    static char[] arr, p, mx;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            M = arr.length;
            p = new char[M];
            mx = new char[M];
            selected = new boolean[M];

            perm(0);
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static void perm(int idx) {
        if (idx == M) {
            String str = new String(p);
            sb.append(str).append("\n");

            return;
        }

        mx[idx] = '0';

        for (int i = 0; i < M; i++) {
            if (!selected[i] && mx[idx] < arr[i]) {
                mx[idx] = arr[i];

                selected[i] = true;
                p[idx] = arr[i];
                perm(idx + 1);
                selected[i] = false;
            }
        }

    }

}
