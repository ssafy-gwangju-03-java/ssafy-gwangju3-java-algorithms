import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_5_4195 {
    static int[] level;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            // level : 각 노드의 층수를 세어주는 1차원 배열
            // 합집합 시 마다 부모 집합의 층수에 자식 집합의 층수를 더해주기
            parent = new int[N*2+1];
            level = new int[N*2+1];
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            HashMap<String, Integer> friends = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");

                String p = s[0];
                String q = s[1];

                if (!friends.containsKey(p)) {
                    friends.put(p, friends.size()+1);
                }
                if (!friends.containsKey(q)) {
                    friends.put(q, friends.size()+1);
                }

                int pn = friends.get(p);
                int qn = friends.get(q);

                System.out.println(union(pn, qn));
            }
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] +=  level[y];
            level[y] = 1;
        }

        return level[x];
    }
}