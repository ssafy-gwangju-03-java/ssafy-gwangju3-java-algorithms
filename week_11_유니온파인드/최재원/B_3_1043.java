import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_3_1043 {
    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_11_유니온파인드/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = makeSet();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        // 처음 진실을 알고있는사람을 0번 집합으로 합치기
        for (int i = 0; i < k; i++) {
            union(0, Integer.parseInt(st.nextToken()));
        }

        // 파티 입력 저장
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] temp = new int[size];

            for (int j = 0; j < size; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            list.add(temp);
        }

        // 파티를 돌며 같이 온 사람들을 같은 집합으로 합치기
        for (int i = 0; i < m; i++) {
            int[] temp = list.get(i);
            if (temp.length >= 2) {
                for (int j = 0; j < temp.length - 1; j++) {
                    union(temp[j], temp[j + 1]);
                }
            }
        }

        // 파티를 돌며 거짓말을 할 수 있는 파티 수 세기
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int[] temp = list.get(i);

            if (canLie(temp)) {
                answer += 1;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static boolean canLie(int[] temp) {
        for (int j = 0; j < temp.length; j++) {
            // 파티에 진실을 알고 있는 사람이 있으면
            if (findSet(temp[j]) == 0) {
                return false;
            }
        }

        return true;
    }

    static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) {
            return;
        }

        if (pa < pb) {
            p[pb] = pa;
        } else {
            p[pa] = pb;
        }
    }

    static int findSet(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = findSet(p[x]);
    }


    static int[] makeSet() {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        return arr;
    }
}
