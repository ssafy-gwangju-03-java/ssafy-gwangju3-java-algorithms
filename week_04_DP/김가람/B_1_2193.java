package week_04_DP.김가람;
import java.util.Scanner;

public class B_1_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bin[] table = new Bin[n];
        table[0] = new Bin(0, 1);
        for (int i = 1; i < n; i++) {
            long zero = table[i-1].z;
            long one = table[i-1].o;
            table[i] = new Bin(one+zero, zero);
        }
        System.out.println(table[n-1].s);
    }

    static class Bin {
        long z;
        long o;
        long s;

        public Bin (long z, long o) {
            this.z = z;
            this.o = o;
            this.s = z+o;
        }
    }
}
