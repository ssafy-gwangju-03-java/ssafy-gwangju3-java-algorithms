import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_3_1043 {
    static int N, M;
    static int[] p;
    static int true_cnt;
    static int true_p = 0;
    static List<List<Integer>> party = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) p[i] = i;

        st = new StringTokenizer(br.readLine());
        true_cnt = Integer.parseInt(st.nextToken());
        if (true_cnt != 0) {
            true_p = Integer.parseInt(st.nextToken());
            for (int i = 1; i < true_cnt; i++) {
                int tmp_true = Integer.parseInt(st.nextToken());
                unionSet(true_p, tmp_true);
            }
        }
//        System.out.println(36);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp_cnt = Integer.parseInt(st.nextToken());
            party.add(new ArrayList<>());
            party.get(i).add(Integer.parseInt(st.nextToken()));
            for (int j = 1; j < tmp_cnt; j++) {
                party.get(i).add(Integer.parseInt(st.nextToken()));
                unionSet(party.get(i).get(j-1), party.get(i).get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int j = 0; j < party.get(i).size(); j++) {
                if (findSet(party.get(i).get(j)) == true_p) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }
    public static void unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) return;

        if (pa == true_p) p[pb] = pa;
//        else if (pb == true_p) p[pa] = pb;
        else p[pa] = pb;
    }
    public static int findSet(int x) {
        if (p[x] == x) return x;
        return p[x] = findSet(p[x]);
    }
}