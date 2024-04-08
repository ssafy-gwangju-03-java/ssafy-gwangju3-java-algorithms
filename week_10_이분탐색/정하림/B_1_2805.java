package java_study.w10;
import java.util.Scanner;

public class B_1_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long key = sc.nextInt();

        long[] arr = new long[N];
        long l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            r = Math.max(r, arr[i]);
        }
        long ans = 0;
        while (l <= r) {
            long m = (l+r) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > m) sum += (arr[i] - m);
            }
            if (sum >= key) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);

    }
}
