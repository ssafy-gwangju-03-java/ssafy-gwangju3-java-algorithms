package java_study.w8;
import java.util.Scanner;

public class B_0_1644 {
    static int N;
    static boolean[] primeIsF;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        primeIsF = new boolean[N + 1];
        primeIsF[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primeIsF[i]) continue;
            for (int j = 2*i; j <= N; j+=i) {
                primeIsF[j] = true;
            }
        }
        for (int s = 2; s <= N; s++) {
            int nw = 0;
            int S = s;
            if (primeIsF[s]) continue;
            while (N >=S) {
                if (!primeIsF[S]) nw += S;
                if (nw > N) break;
                if (nw == N) {
                    cnt++;
                    break;
                }
                S++;
            }
        }
        System.out.println(cnt);
    }
}
