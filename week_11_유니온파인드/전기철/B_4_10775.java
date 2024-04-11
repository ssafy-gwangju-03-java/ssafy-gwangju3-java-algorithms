package week_11_유니온파인드.전기철;

import java.util.Scanner;

public class B_4_10775 {
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int x = sc.nextInt();
        p = new int[g + 1];
        for (int i = 0; i < g + 1; i++) {
            p[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            int chk = sc.nextInt();
            int port = findset(chk);
            if (port != 0) {
                union(port, port - 1);
                cnt += 1;
            } else {
                break;
            }
        }
        System.out.println(cnt);
        sc.close();
    }

    static void union(int a, int b) {
        int pa = findset(a);
        int pb = findset(b);

        if (pa == pb) {
            return;
        } else {
            p[pa] = p[pb];
        }
    }

    static int findset(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = findset(p[a]);
    }
}
