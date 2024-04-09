package java_study.w11;

import java.util.*;

public class B_1_17352 {
    static int N;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        p = new int[N+1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < N-2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionSet(a, b);
        }

//        HashSet<Integer> ans = new HashSet<>(Arrays.asList())
        for (int i = 1; i <= N; i++) {
            findSet(i);
        }

//        System.out.println(Arrays.toString(p));
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!ans.contains(p[i])) ans.add(p[i]);
        }
        System.out.printf("%d %d", ans.get(0), ans.get(1));
    }
    public static  void unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if (pa == pb) return;
        p[pb] = pa;
    }

    public static int findSet(int a) {
        if (a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }
}
