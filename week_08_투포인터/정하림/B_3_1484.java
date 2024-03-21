package java_study.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3_1484 {
    static int G;
    static boolean flag = true;
    static int s, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        s = (int) Math.sqrt(G + 1);
        e = s;
        while (Math.pow(e, 2) - Math.pow(e - 1, 2) <= G) e++;
        weight(s, 1);

        if (flag) {
            System.out.println(-1);
        }

    }

    // n now b before
    public static void weight(int n, int b) {
        while (n < e) {
            double calc =  Math.pow(n, 2) - Math.pow(b, 2);
            if (calc < G){
                n++;
                continue;
            }
            if (calc == G) {
                System.out.println(n);
                flag = false;
                n++;
                b++;
                continue;
            }
            b++;
        }




    }
}
