import java.io.*;
import java.util.*;

public class B_3_20056 {

    static int N,M,K;
    static List<int[]> list;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{r, c, m, s, d});
        }

        for (int q = 0; q < K; q++) {
            move();
            Collections.sort(list, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });
            calc();
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++)
            sum += list.get(i)[2];

        System.out.println(sum);
    }

    public static void calc() {
        List<int[]> tmp = new ArrayList<>();
        int i = 0;

        while(true) {
            if (i + 1 >= list.size()) break;
            int nr = list.get(i)[0], nc = list.get(i)[1];
            int mm = list.get(i)[2], ms = list.get(i)[3];
            int cnt = 1, odd = 0, even = 0, start = i;

            if (list.get(i)[4] % 2 == 0) even++;
            else odd++;
            i++;

            if (nr == list.get(i)[0] && nc == list.get(i)[1]) {
                while (true) {
                    mm += list.get(i)[2];
                    ms += list.get(i)[3];
                    cnt++;

                    if (list.get(i)[4] % 2 == 0) even++;
                    else odd++;
                    nr = list.get(i)[0]; nc = list.get(i)[1];
                    i++;

                    if (i >= list.size() || list.get(i)[0] != nr || list.get(i)[1] != nc) {
                        int tm = mm / 5, ts = ms / cnt;
                        if (tm != 0) {
                            if (even == cnt || odd == cnt) {
                                for (int j = 0; j < 8; j++)
                                    if (j % 2 == 0)
                                        tmp.add(new int[]{nr, nc, tm, ts, j});
                            }
                            else {
                                for (int j = 0; j < 8; j++)
                                    if (j % 2 != 0)
                                        tmp.add(new int[]{nr, nc, tm, ts, j});
                            }
                        }
                        for (int j = start; j < start + cnt; j++)
                            list.remove(start);
                        i -= cnt;
                        break;
                    }
                }
            }
        }

        list.addAll(tmp);
    }

    public static void move() {
        for(int i = 0; i < list.size(); i++) {
            int r = list.get(i)[0] + dx[list.get(i)[4]] * (list.get(i)[3] % N);
            int c = list.get(i)[1] + dy[list.get(i)[4]] * (list.get(i)[3] % N);

            if (r > N) r -= N;
            else if (r < 1) r += N;
            if (c > N) c -= N;
            else if (c < 1) c += N;

            list.set(i, new int[]{r, c, list.get(i)[2], list.get(i)[3], list.get(i)[4]});
        }
    }
}

