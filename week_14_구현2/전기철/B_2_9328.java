import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2_9328 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static String[][] lst;
    static int h, w;
    static int[] door;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();
            lst = new String[h + 2][w + 2];
            for (int i = 0; i < w + 2; i++) { // 둘레를 "." 으로 채워 갈 수 있는 길로 처리
                lst[0][i] = ".";
                lst[h + 1][i] = ".";
            }
            for (int i = 1; i < h + 1; i++) {
                String[] s = sc.nextLine().split("");
                for (int j = 0; j < w + 2; j++) {
                    if (j == 0) {
                        lst[i][j] = ".";
                    } else if (j == w + 1) {
                        lst[i][j] = ".";
                    } else {
                        lst[i][j] = s[j - 1];
                    }
                }
            }

            door = new int[26];
            String[] keys = sc.nextLine().split("");
            for (String key : keys) {
                if (key.equals("0")) {
                    break;
                }
                int point = key.charAt(0);
                door[point - 97] = 1; // 열쇠 보유 처리
            }

            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    int point = lst[i][j].charAt(0);
                    if (65 <= point && point < 97 && door[point - 65] != 0) {
                        lst[i][j] = "."; // 대문자 영어 (문), 해당 키가 존재할 경우 문 열기
                    }
                }
            }
            System.out.println(bfs());
        }
    }

    static int bfs() {
        int ans = 0;
        int[][] vis = new int[h + 2][w + 2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 }); // (0,0) start
        vis[0][0] = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < w + 2 && 0 <= ny && ny < h + 2 && !lst[ny][nx].equals("*") && vis[ny][nx] == 0) { // 방문한 적 없는 길일 때
                    if (lst[ny][nx].equals(".")) { // 길 만남
                        vis[ny][nx] = 1;
                        q.add(new int[] { nx, ny });
                    } else if (lst[ny][nx].equals("$")) { // 돈 만남
                        ans += 1;
                        vis[ny][nx] = 1;
                        lst[ny][nx] = "."; // 돈 털고 갈 수 있는 길로 변경
                        q.add(new int[] { nx, ny });

                    } else {
                        int point = lst[ny][nx].charAt(0);
                        if (65 <= point && point < 97) { // 대문자(문) 일 때
                            if (door[point - 65] != 0) { // 열쇠가 있다면
                                lst[ny][nx] = "."; // 열기
                                vis[ny][nx] = 1;
                                q.add(new int[] { nx, ny });
                            }
                        } else { // 열쇠
                            door[point - 97] = 1; // 열쇠 추가
                            lst[ny][nx] = ".";
                            vis = new int[h + 2][w + 2]; // 방문 처리 초기화(열쇠를 먹었으니 다시 탐색)
                            vis[ny][nx] = 1;
                            q = new LinkedList<>(); // 새로 탐색 시작
                            q.add(new int[] { nx, ny });
                        }
                    }

                }
            }
        }
        return ans;
    }
}