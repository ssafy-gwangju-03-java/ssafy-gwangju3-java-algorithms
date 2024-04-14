package java_study.w11;

import java.util.*;

public class B_5_4195 {

    static int F;
    static int[] p; //유니온 집합셋
    static int[] friend_cnt; //각 인덱스별 친구의 수
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            F = sc.nextInt();

            p = new int[F * 2];
            friend_cnt = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                p[i] = i;
                friend_cnt[i] = 1;
            }

            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>(); //<String : 이름, index : (노드번호) >
            for (int i = 0; i < F; i++) {
                String name1 = sc.next();
                String name2 = sc.next();

                if (!map.containsKey(name1)) map.put(name1, idx++);
                if (!map.containsKey(name2)) map.put(name2, idx++);

                sb.append(unionSet(map.get(name1), map.get(name2))).append("\n");
            }

        }
        System.out.println(sb.toString());

    }

    public static int unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) return friend_cnt[pa];

        if (pa < pb) {
            p[pb] = pa;
            friend_cnt[pa] += friend_cnt[pb];
            return friend_cnt[pa];
        } else {
            p[pa] = pb;
            friend_cnt[pb] += friend_cnt[pa];
            return friend_cnt[pb];
        }
    }

    public static int findSet(int x) {
        if (x == p[x]) return x;
        else return p[x] = findSet(p[x]);
    }
}
