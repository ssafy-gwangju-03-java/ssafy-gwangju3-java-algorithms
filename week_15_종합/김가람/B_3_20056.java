package week_15_종합.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class B_3_20056 {
    static int N;
    static int M;
    static int K;
    static HashMap<Integer, FireBall> totalBalls;
    static int globalIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        K = Integer.parseInt(info[2]);

        // << 인덱스 key, FireBall 객체 value >> 를 저장할 HashMap
        // ex) << 0(번 공), FireBall(r, c, m, s, d) >>
        totalBalls = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] b = br.readLine().split(" ");
            int r = Integer.parseInt(b[0]);
            int c = Integer.parseInt(b[1]);
            int m = Integer.parseInt(b[2]);
            int s = Integer.parseInt(b[3]);
            int d = Integer.parseInt(b[4]);
            totalBalls.put(i, new FireBall(r - 1, c - 1, m, s, d));
        }

        // 이후 새로 생길 공들의 key는 해당 전역변수를 증가시키며 등록
        globalIdx = M;

        System.out.println(move());
    }

    static int move() {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        // 마법사가 이동을 K번 명령
        while (K-- > 0) {

            // 이동 시 마다 파이어볼들의 겹침을 파악할 map
            // Space는 FireBall의 key와 한 공간에 머무르는 FireBall의 갯수 등의 좌표 공간 정보를 저장해 줄 객체
            Space[][] map = new Space[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new Space();
                }
            }

            // HashMap 순회하며 각 파이어볼들의 이동 정보를 갱신해준 후 지도에 표시
            Set<Integer> keys = totalBalls.keySet();

            for (Integer key : keys) {
                FireBall currBall = totalBalls.get(key);

                int nr = currBall.r + dr[currBall.d] * currBall.s;
                int nc = currBall.c + dc[currBall.d] * currBall.s;

                //  1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다
                if (!inRange(nr, nc)) {
                    nr = (nr % N < 0) ? nr % N + N : nr % N;
                    nc = (nc % N < 0) ? nc % N + N : nc % N;
                }

                // 이동 후 위치 정보 갱신
                currBall.r = nr;
                currBall.c = nc;

                // 위치를 지도에 표시
                map[nr][nc].balls.add(key);
            }

            // 지도 배열 전체를 순회하며 2개 이상의 파이어볼이 있는 칸이 있는지 파악
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // getCount는 Space에 머무르는 파이어볼들의 갯수를 반환
                    int inCurrSpace = map[i][j].getCount();

                    // 만약 해당 공간에 2개 이상의 파이어볼이 함께 있다면
                    if (inCurrSpace > 1) {
                        int mass = 0;               // 질량의 합
                        int speed = 0;              // 속력의 합
                        int rem = -1;               // 파이어볼들의 방향의 홀짝을 판단해줄 나머지 값
                        boolean allSame = true;     // 방향이 전부 홀수 혹은 짝수인지 여부를 저장해줄 boolean 변수

                        // 해당 공간의 파이어볼들을 순회한다
                        for (Integer key : map[i][j].balls) {
                            FireBall currBall = totalBalls.get(key);
                            mass += currBall.m;
                            speed += currBall.s;

                            // rem이 갱신되지 않은 상태라면 현재의 rem을 넣어준다
                            if (rem == -1) {
                                rem = currBall.d % 2;

                            // rem에 이미 나머지값이 들어가 있는 상태라면 동일여부를 판단
                            } else {
                                if (rem != currBall.d % 2) {
                                    allSame = false;
                                }
                            }

                            // 파이어볼들은 모두 하나로 합쳐지므로 현재의 파이어볼은 소멸
                            totalBalls.remove(key);
                        }

                        // 파이어볼 4개로 나누기
                        mass /= 5;
                        speed /= inCurrSpace;
                        rem = (allSame) ? 0 : 1;

                        // 질량이 0인 파이어볼은 소멸
                        if (mass > 0) {
                            for (int d = 0; d < 8; d++) {
                                if (d % 2 == rem) {
                                    totalBalls.put(globalIdx++, new FireBall(i, j, mass, speed, d));
                                }
                            }
                        }
                    }
                }
            }
        }

        // K번 이동 후 남은 파이어볼의 질량의 합 리턴
        int massSum = 0;

        for (Integer key : totalBalls.keySet()) {
            massSum += totalBalls.get(key).m;
        }

        return massSum;
    }

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static class Space {
        ArrayList<Integer> balls;

        public Space() {
            this.balls = new ArrayList<>();
        }

        public int getCount() {
            return balls.size();
        }
    }

    static boolean inRange(int r, int c) {
        return (0 <= r && r < N && 0 <= c && c < N);
    }
}


