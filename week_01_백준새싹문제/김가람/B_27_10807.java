import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_27_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split(" ");
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        for (String num : arr) {
            if (Integer.parseInt(num) == v) {
                count++;
            }
        }

        System.out.println(count);
    }
}