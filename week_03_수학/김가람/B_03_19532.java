import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B_03_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);
        int e = Integer.parseInt(s[4]);
        int f = Integer.parseInt(s[5]);

        int x = (c * e - b * f) / (a * e - b * d);
        int y = (c * d - a * f) / (b * d - a * e);

        System.out.printf("%d %d", x, y);
    }
}