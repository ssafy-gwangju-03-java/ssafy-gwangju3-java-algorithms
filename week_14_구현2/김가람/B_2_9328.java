package week_14_구현2.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_2_9328 {
    static int H;
    static int W;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[] keyBag;
    static ArrayList<int[]> entrances;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] info = br.readLine().split(" ");
            H = Integer.parseInt(info[0]);
            W = Integer.parseInt(info[1]);

            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            //            a     b    ...    z
            // keyBag = [true, false, ..., false]
            keyBag = new boolean[26];

            // 보유하고 있는 열쇠 표시
            String keys = br.readLine();
            if (!keys.equals("0")) {
                char[] keyArr = keys.toCharArray();
                for (char c : keyArr) {
                    keyBag[c - 'a'] = true;
                }
            }

            // 입구 좌표들을 넣어줄 ArrayList
            entrances = new ArrayList<>();

            // 훔친 문서 갯수
            ans = 0;

            // 먼저 가장자리를 돌면서 입구를 찾아보기
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (i == 0 || i == H-1 || j == 0 || j == W-1) {

                        // '.'이면 곧바로 입구 좌표로 등록
                        if (map[i][j] == '.') {
                            entrances.add(new int[]{i, j});

                        // 열쇠 있으면 주운 후 입구 좌표로 등록
                        } else if (Character.isLowerCase(map[i][j])) {
                            keyBag[map[i][j] - 'a'] = true;
                            map[i][j] = '.';
                            entrances.add(new int[]{i, j});

                        // 문서 있으면 주운 후 입구 좌표로 등록
                        } else if (map[i][j] == '$') {
                            ans++;
                            map[i][j] = '.';
                            entrances.add(new int[]{i, j});
                        }

                    }
                }
            }

            // 먼저 찾아놓은 입구들을 활용해서 bfs 함수 가동
            // bfs 함수는 새로운 열쇠를 찾으면 true, 못 찾으면 false를 반환
            // 새로운 열쇠를 주웠다 == 문이 하나 없어진 새로운 map을 얻었다 -> 새롭게 다시 탐색
            // 새로운 열쇠를 못주웠다 == 더 이상 새로 탐색할 곳이 없다 -> break
            while (true) {
                visited = new boolean[H][W];
                boolean found = bfs();
                if (!found) break;
            }

            System.out.println(ans);
        }
    }

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 탐색 전에 가장자리 다시 돌면서 새로 얻은 열쇠로 열 수 있는 문 있는지 먼저 확인
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i == 0 || i == H-1 || j == 0 || j == W-1) {
                    if (Character.isUpperCase(map[i][j]) && keyBag[map[i][j]-'A']) {
                        map[i][j] = '.';
                        entrances.add(new int[]{i, j});
                    }
                }
            }
        }

        for (int[] entrance : entrances) {
            visited[entrance[0]][entrance[1]] = true;
            q.add(entrance);
        }

        // 해당 회차 bfs에서 반환할 boolean 값
        boolean foundKey = false;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc] && map[nr][nc] != '*') {

                    // 빈칸이면 계속 탐색
                    if (map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});

                    // 열수 있는 문 만나면 문 없앤후 계속 탐색
                    } else if (Character.isUpperCase(map[nr][nc]) && keyBag[map[nr][nc]-'A']) {
                        map[nr][nc] = '.';
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});

                    // 열쇠를 만나면
                    } else if (Character.isLowerCase(map[nr][nc])) {

                        // 원래 있는 열쇠면 그냥 주워주기만 한 후 계속 탐색
                        if (keyBag[map[nr][nc] - 'a']) {
                            map[nr][nc] = '.';
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});

                        // 새로 찾은 열쇠면 반환값 true로 바꿔주고 keyBag에 넣어준 다음 계속 탐색
                        } else {
                            foundKey = true;
                            keyBag[map[nr][nc] - 'a'] = true;
                            map[nr][nc] = '.';
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }

                    // 문서 만나면 ans값 1 올려주고 주워준 후 계속 탐색
                    } else if (map[nr][nc] == '$') {
                        ans++;
                        map[nr][nc] = '.';
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return foundKey;
    }
}



