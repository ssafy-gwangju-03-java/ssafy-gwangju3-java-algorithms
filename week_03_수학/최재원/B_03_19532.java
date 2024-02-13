import java.io.*;
import java.util.Arrays;

public class B_03_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = arr[0];
        int b = arr[1];
        int p = arr[2];
        int c = arr[3];
        int d = arr[4];
        int q = arr[5];

        int x = (d * p - b * q) / (a * d - b * c);
        int y = (-c * p + a * q) / (a * d - b * c);

        System.out.println(x + " " + y);
    }
}
