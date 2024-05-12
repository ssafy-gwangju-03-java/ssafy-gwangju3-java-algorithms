package week_15_종합.전기철;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_3_20056 {
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static List<Ball>[][] lst;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        lst = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lst[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int mass = sc.nextInt();
            int speed = sc.nextInt();
            int dir = sc.nextInt();
            lst[r][c].add(new Ball(mass, speed, dir));
        }

        for (int i = 0; i < k; i++) {
            move();
            boom();
        }

        System.out.println(totalMass());
        sc.close();
    }

    static void move() { // 이동
        List<Ball>[][] arr = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                for (Ball ball : lst[y][x]) {
                    int nx = (x + dx[ball.dir] * ball.speed) % n;
                    int ny = (y + dy[ball.dir] * ball.speed) % n;
                    if (nx < 0)
                        nx += n;
                    if (ny < 0)
                        ny += n;
                    arr[ny][nx].add(ball);
                }
            }
        }
        lst = arr;
    }

    static void boom() { // 두개 이상 겹쳤을 때 폭발하는 함수
        List<Ball>[][] arr = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (lst[y][x].size() >= 2) {
                    int cnt = lst[y][x].size();
                    int massSum = 0;
                    int speedSum = 0;
                    int[] sumDir = new int[2];
                    for (Ball ball : lst[y][x]) {
                        massSum += ball.mass;
                        speedSum += ball.speed;
                        sumDir[ball.dir % 2]=1;
                    }
                    int newMass = massSum / 5;
                    int newSpeed = speedSum / cnt;
                    int[] directions = (sumDir[0]+sumDir[1]==2) ? new int[] {1,3,5,7 } // 방향 홀 짝 둘다 있는 경우 1 3 5 7
                            : new int[] {0, 2, 4, 6 };

                    for (int dir : directions) {
                        if (newMass > 0) {
                            arr[y][x].add(new Ball(newMass, newSpeed, dir));
                        }
                    }
                } else {
                    arr[y][x].addAll(lst[y][x]);
                }
            }
        }
        lst = arr;
    }

    static int totalMass() { // 전체 질량 구하는 함수
        int total = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                for (Ball ball : lst[y][x]) {
                    total += ball.mass;
                }
            }
        }
        return total;
    }

    static class Ball { // 파이어볼 입력 클래스
        int mass, speed, dir;

        Ball(int mass, int speed, int dir) {
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
        }
    }
}