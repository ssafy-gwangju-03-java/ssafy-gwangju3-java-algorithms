import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3_17281 {
    static int N, answer;
    static int[][] hits;
    static int[] order;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hits = new int[N][10];
        order = new int[10];
        selected = new boolean[10];
        order[4] = 1;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++) {
                hits[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(1);

        System.out.println(answer);
        br.close();
    }

    public static void perm(int cnt) {
        if(cnt == 10) {
            solve();
            return;
        }

        for(int i = 2; i <= 9; i++) {
            if(cnt == 4) {
                cnt += 1;
                i -= 1;
                continue;
            }

            if(selected[i]) continue;

            selected[i] = true;
            order[cnt] = i;
            perm(cnt + 1);
            selected[i] = false;
        }
    }

    public static void solve() {
        int score = 0;
        int startNo = 1;

        for(int i = 0; i < N; i++) {
            int outCnt = 0;
            boolean[] base = new boolean[4];

            int cur = startNo;

            while(outCnt < 3) {
                switch(hits[i][order[cur]]) {
                    case 0:
                        outCnt += 1;
                        break;
                    case 1:
                        if(base[3]) {
                            score += 1;
                        }
                        base[3] = base[2] ? true : false;
                        base[2] = base[1] ? true : false;
                        base[1] = true;
                        break;
                    case 2:
                        if(base[3]) {
                            score += 1;
                        }
                        if(base[2]){
                            score += 1;
                        }
                        base[3] = base[1] ? true : false;
                        base[2] = true;
                        base[1] = false;
                        break;
                    case 3:
                        for(int b = 1; b <= 3; b++) {
                            if(base[b]) {
                                score += 1;
                            }
                            base[b] = false;
                        }
                        base[3] = true;
                        break;
                    case 4:
                        for(int b = 1; b <= 3; b++) {
                            if(base[b]) {
                                score += 1;
                            }
                            base[b] = false;
                        }
                        score += 1;
                        break;
                }

                cur = (cur + 1) % 10;
                if(cur == 0) {
                    cur = 1;
                }
            }

            startNo = cur;
        }

        answer = Math.max(answer, score);
    }
}
