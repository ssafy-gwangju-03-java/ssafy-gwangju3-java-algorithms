import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_5_4195 {
    static int[] p, count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\Jaewon\\algorithm\\ssafy-gwangju3-java-algorithms\\week_11_유니온파인드\\최재원\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int F = Integer.parseInt(br.readLine());

            p = makeSet(F);

            // 대표의 카운트를 증가시켜 네트워크에 몇 명이 있는지 구하자
            count = new int[F * 2 + 1];
            Arrays.fill(count, 1);

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String[] friends = new String[2];

                // 처음 등장한 친구면 맵에 넣고 번호 할당
                for (int j = 0; j < 2; j++) {
                    friends[j] = st.nextToken();

                    if (!map.containsKey(friends[j])) {
                        map.put(friends[j], map.size() + 1);
                    }
                }

                union(map.get(friends[0]), map.get(friends[1]));

                sb.append(count[findSet(map.get(friends[0]))]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static int[] makeSet(int f) {
        int[] arr = new int[f * 2 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return arr;
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a == b) {
            return;
        }

        p[b] = a;
        count[a] += count[b];
    }

    static int findSet(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = findSet(p[x]);
    }
}
