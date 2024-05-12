package week_15_종합.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_3_20056 {
    static int N, M, K;
    static ArrayList<Fireball> fireballs;
    static ArrayList<Fireball>[][] map;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};	//방향 r값 변경값
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_15_종합/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fireballs = new ArrayList<>();
        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
            checkFireball();
        }

        int answer = 0;
        for (Fireball fireball : fireballs) {
            answer += fireball.m;
        }

        System.out.println(answer);
        br.close();
    }

    static void move() {
        for (Fireball fireball : fireballs) {
            int nr = (fireball.r + N + dr[fireball.d] * (fireball.s % N)) % N;
            int nc = (fireball.c + N + dc[fireball.d] * (fireball.s % N)) % N;

            fireball.r = nr;
            fireball.c = nc;

            map[nr][nc].add(fireball);
        }
    }

    static void checkFireball() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j].isEmpty()) {
                    continue;
                } else if (map[i][j].size() == 1) {
                    map[i][j] = new ArrayList<>();
                    continue;
                }

                int mSum = 0;
                int sSum = 0;

                boolean odd = map[i][j].getFirst().d % 2 == 1;
                boolean even = map[i][j].getFirst().d % 2 == 0;

                for (Fireball fireball : map[i][j]) {
                    mSum += fireball.m;
                    sSum += fireball.s;
                    odd = odd && fireball.d % 2 == 1;
                    even = even && fireball.d % 2 == 0;

                    fireballs.remove(fireball);
                }

                int newMass = mSum / 5;
                int size = map[i][j].size();
                map[i][j] = new ArrayList<>();


                if (newMass == 0) {
                    continue;
                }

                int newS = sSum / size;
                if (odd || even) {
                    for (int k = 0; k < 8; k += 2) {
                        fireballs.add(new Fireball(i, j, newMass, newS, k));
                    }
                } else {
                    for (int k = 1; k < 8; k += 2) {
                        fireballs.add(new Fireball(i, j, newMass, newS, k));
                    }
                }
            }
        }
    }
}
