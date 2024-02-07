package week_03_수학.김가람;
import java.io.*;

public class B_01_1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int n = Integer.parseInt(temp[2]);
        int result = a % b;

        for (int i = 1; i < n; i++) {
            a = result * 10;
            result = a % b;
        }

        int answer = result*10 / b;

        System.out.println(answer);
    }
}