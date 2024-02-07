package java_study.w3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3_19532 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int a = Integer.parseInt(text[0]);
        int b = Integer.parseInt(text[1]);
        int c = Integer.parseInt(text[2]);
        int d = Integer.parseInt(text[3]);
        int e = Integer.parseInt(text[4]);
        int f = Integer.parseInt(text[5]);

        int x = (c * e - f * b) / (a * e - d * b);
        int y = (c * d - f * a) / (b * d - e * a);
        System.out.printf("%d %d", x, y);
    }
}
