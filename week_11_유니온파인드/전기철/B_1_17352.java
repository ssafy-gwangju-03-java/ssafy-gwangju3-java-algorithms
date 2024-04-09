package week_11_유니온파인드.전기철;

import java.util.Scanner;

public class B_1_17352 {
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n-2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        for(int i=1;i<n+1;i++){
            if(i==findset(i)){
                System.out.print(i+" ");
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
