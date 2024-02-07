import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_02_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long mySum = 0;

        for (int i = 0; i < s[0].length(); i++) {
            for (int j = 0; j < s[1].length(); j++) {
                mySum += Long.parseLong(String.valueOf(s[0].charAt(i))) * Integer.parseInt(String.valueOf(s[1].charAt(j)));
            }
        }

        System.out.println(mySum);
    }
}
