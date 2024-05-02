package week_14_구현2.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2_9328 {
    static int N, M;
    static char[][] arr;
    static Set<Character> keys;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "r = " + r + " c = "+ c;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_14_구현2/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc= 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 테두리 빈칸으로 두르기
            arr = new char[N + 2][M + 2];
            for (int i = 0; i < N + 2; i++) {
                Arrays.fill(arr[i],'.');
            }

            // 배열 중앙에 입력 받기
            for (int i = 1; i < N + 1; i++) {
                char[] line = br.readLine().toCharArray();

                for (int j = 1; j < M + 1; j++) {
                    arr[i][j] = line[j - 1];
                }
            }


            keys = new HashSet<>();
            for (char key : br.readLine().toCharArray()) {
                keys.add(key);
            }

            int answer = bfs();

            System.out.println(answer);
        }

        br.close();
    }

    static int bfs() {
        boolean[][] visited = new boolean[N + 2][M + 2];
        Queue<Point> queue = new ArrayDeque();

        visited[0][0] = true;
        queue.add(new Point(0, 0));

        int answer = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                boolean inRange = 0 <= nr && nr < N + 2 && 0 <= nc && nc < M + 2;

                if (inRange && !visited[nr][nc] && arr[nr][nc] != '*') {
                    char now = arr[nr][nc];

                    if (now == '.') {
                        // 빈칸이면 큐에 추가
                        visited[nr][nc] = true;
                        queue.add(new Point(nr, nc));
                    } else if (Character.isUpperCase(now)) {
                        // 열 수 있는 문이면 큐에 넣기
                        if (keys.contains(Character.toLowerCase(now))) {
                            arr[nr][nc] = '.';
                            visited[nr][nc] = true;
                            queue.add(new Point(nr, nc));
                        }
                    } else if (Character.isLowerCase(now)) {
                        // 있는 열쇠면 그대로 진행
                        // 새로운 열쇠면 set에 추가, (0, 0)부터 bfs 시작
                        if (keys.contains(now)) {
                            arr[nr][nc] = '.';
                            visited[nr][nc] = true;
                            queue.add(new Point(nr, nc));
                        } else {
                            keys.add(now);
                            arr[nr][nc] = '.';

                            visited = new boolean[N + 2][M + 2];
                            visited[0][0] = true;

                            queue = new ArrayDeque();
                            queue.add(new Point(0, 0));
                        }
                    } else if(now == '$') {
                        // 문서면 카운트 증가
                        answer += 1;
                        arr[nr][nc] = '.';
                        visited[nr][nc] = true;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }

        return answer;
    }
}
