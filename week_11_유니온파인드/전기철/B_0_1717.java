package week_11_유니온파인드.전기철;

import java.util.Arrays;
import java.util.Scanner;

public class B_0_1717 {
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (x == 0) {
                union(a, b);
            } else {
                if (findset(a) == findset(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int pa = findset(a);
        int pb = findset(b);

        if (pa == pb) {
            return;
        } else {
            p[pb] = p[pa];
        }
    }

    static int findset(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = findset(p[a]);
    }
}
