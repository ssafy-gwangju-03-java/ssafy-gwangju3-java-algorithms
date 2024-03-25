package week_08_투포인터.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int e = (int) Math.ceil(Math.sqrt(G));
        int s = 1;
        boolean didFind = false;
        while (s < e) {
            int cha = e * e - s * s;
            if (cha == G) {
                didFind = true;
                System.out.println(e);
                e++;
            } else if (cha > G) {
                s++;
            } else {
                e++;
            }
            if (s - e == 1 && cha > G) break;
        }
        if (!didFind) {
            System.out.println(-1);
        }
    }
}