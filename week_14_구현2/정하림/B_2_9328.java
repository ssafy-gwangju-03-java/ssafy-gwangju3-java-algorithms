import java.util.*;

public class B_2_9328 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] docs;
    static List<Integer> keys = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            h = sc.nextInt() + 2;
            w = sc.nextInt() + 2;

            map = new char[h][w];
            visited = new boolean[h][w];
            docs = new boolean[h][w];
            for (int j = 0; j < w; j++) {
                map[0][j] = '.';
                map[h-1][j] = '.';
            }
            for (int i = 1; i < h-1; i++) {
                map[i][0] = '.';
                map[i][w-1] = '.';
                String line = sc.next();
                for (int j = 1; j < w-1; j++) {
                    map[i][j] = line.charAt(j-1);
                }
            }

            keys.clear();
            String tmp = sc.next();
            if (!tmp.equals("0")) {
                for (char key : tmp.toCharArray()) {
                    keys.add((int) key);
                }
            }

            cnt = 0;
            bfs();

            System.out.println(cnt);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (0 > nr || nr >= h || 0 > nc || nc >= w || visited[nr][nc] || map[nr][nc] == '*') {
                    continue;
                } else {
                    int  e = (int) map[nr][nc];
                    if ('A' <= e && e <= 'Z') {
                        if (!keys.contains(e + ('a'-'A'))) continue;
                    } else if ('a' <= e && e <= 'z') {
                        if (!keys.contains(e)) {
                            keys.add(e);
                            visited = new boolean[h][w];
                        }
                    } else if (map[nr][nc] == '$' && !docs[nr][nc]) {
                        cnt++;
                        docs[nr][nc] = true;

                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
