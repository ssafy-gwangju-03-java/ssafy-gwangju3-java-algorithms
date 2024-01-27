import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_27_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int repetitions = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st2.nextToken());

        int count = 0;

        for (int i = 0; i < repetitions; i++) {
            if (num == Integer.parseInt(st.nextToken())) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
