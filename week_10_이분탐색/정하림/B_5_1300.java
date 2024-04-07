package java_study.w10;

import java.util.Scanner;

public class B_5_1300 {
    static long N, k, l, h;
    /*
    1 2 3 4 5
    2 4 6 8 10
    3 6 9 12 15
    4 8 12 16 20
    5 10 15 20 25
    1 2 3
    2 4 6
    3 6 9
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();
        l = 1;
        h = k;
        while (l < h) {
            long mid = (l + h) / 2;
//            System.out.println(mid);
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid/i);
            }

            if (sum >= k) h = mid;
            else l=mid+1;

        }
        System.out.println(l);

    }
}
