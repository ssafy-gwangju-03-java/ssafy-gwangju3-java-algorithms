import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_01_1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] text = br.readLine().split(" ");

        int A = Integer.parseInt(text[0]);
        int B = Integer.parseInt(text[1]);
        int N = Integer.parseInt(text[2]);

        int temp = A % B;
        int result = 0;

        for (int i = 0; i < N; i++) {
            temp *= 10;
            result = temp / B;
            temp %= B;
        }

        System.out.println(result);
    }
}
