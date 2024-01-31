import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_02_16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        char[] arr = str.toCharArray();

        String keyword = br.readLine();

        for (char c : arr) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }

        if (sb.toString().contains(keyword)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
