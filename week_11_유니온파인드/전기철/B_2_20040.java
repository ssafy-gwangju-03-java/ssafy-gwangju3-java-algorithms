package week_11_유니온파인드.전기철;

import java.util.Scanner;

public class B_2_20040 {
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        p = new int[n + 1];
        int result=0;
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(findset(a)!=findset(b)){
                union(a, b);
            }
            else{
                result=i+1;
                break;
            }
        }
        System.out.println(result);
    }

    static void union(int a, int b) {
        int pa = findset(a);
        int pb = findset(b);

        if (pa == pb) {
            return;
        } else {
            p[pb] = pa;
        }
    }

    static int findset(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = findset(p[a]);
    }
}
