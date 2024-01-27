import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_28_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        boolean[] submitArray = new boolean[30];

        Arrays.fill(submitArray, false);

        for (int i = 1; i <= 28; i++) {
            st = new StringTokenizer(br.readLine());

            submitArray[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        for (int i = 0; i < submitArray.length; i++) {
            if (!submitArray[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
