package java_study.w8;
import java.util.*;

public class B_0_2531 {
    static int N, d, k, c;
    static int[] sushi;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, select_k(i));
            if (max == k + 1) {
                break;
            }
        }
        System.out.println(max);

    }

    public static int select_k(int s) {
        cnt = 1;
        Set<Integer> select = new HashSet<>();
        select.add(c);
        int e = (s + k - 1) % N;
        if (e > s) {
            for (int i = s; i <= e; i++) {
                select.add(sushi[i]);
            }
        }else {
            for (int i = 0; i <= e; i++) {
                select.add(sushi[i]);
            }
            for (int i = s; i < N; i++) {
                select.add(sushi[i]);
            }
        }
        return select.size();
    }
}
