import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_00_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num1 = br.readLine().split(" ");
        String[] num2 = br.readLine().split(" ");

        int numerator1 = Integer.parseInt(num1[0]);
        int numerator2 = Integer.parseInt(num2[0]);
        int denominator1 = Integer.parseInt(num1[1]);
        int denominator2 = Integer.parseInt(num2[1]);

        int numerator = numerator1*denominator2 + numerator2*denominator1;
        int denominator = denominator1*denominator2;

        int num = gcd(numerator, denominator);

        System.out.println(numerator/num + " " + denominator/num);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
