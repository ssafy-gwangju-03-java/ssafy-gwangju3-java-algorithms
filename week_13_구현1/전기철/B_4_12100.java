package week_13_구현1.전기철;

import java.util.Scanner;

public class B_4_12100 {
    static int n;
    static int[][] lst;
    static int mx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        lst=new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                lst[i][j] = Integer.parseInt(s[j]);
            }
        }

        mx = 0;
        game(0);
        System.out.println(mx);
        sc.close();
    }

    static void game(int k) {

        if (k == 5) {
            for (int[] temp : lst) {
                int now = 0;
                for (int i = 0; i < n; i++) {
                    now = Math.max(now, temp[i]);
                }
                if (now > mx) {
                    mx = now;
                }
            }
            return;
        }

        int[][] new_lst = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_lst[i][j] = lst[i][j];
            }
        }

        for (int p = 0; p < 4; p++) {
            go(p);
            game(k + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    lst[i][j] = new_lst[i][j];
                }
            }
        }

    }

    static void go(int p) {
        if (p == 0) { // 상
            for (int x = 0; x < n; x++) {
                int check = 0;
                for (int y = 1; y < n; y++) {
                    if (lst[y][x] != 0) {
                        int now = lst[y][x];
                        lst[y][x] = 0;
                        if (lst[check][x] == now) { // 같은 숫자 2개 -> 합쳐짐
                            lst[check][x] = now * 2;
                            check += 1;
                        } else if (lst[check][x] == 0) { // 빈 자리 -> 그자리로 이동
                            lst[check][x] = now;
                        } else { // 다른 숫자 있음 -> 합치기 x
                            check += 1;
                            lst[check][x] = now;
                        }
                    }
                }
            }
        } else if (p == 1) { // 하
            for (int x = 0; x < n; x++) {
                int check = n - 1;
                for (int y = n - 2; y > -1; y--) {
                    if (lst[y][x] != 0) {
                        int now = lst[y][x];
                        lst[y][x] = 0;
                        if (lst[check][x] == now) {
                            lst[check][x] = now * 2;
                            check -= 1;
                        } else if (lst[check][x] == 0) {
                            lst[check][x] = now;
                        } else {
                            check -= 1;
                            lst[check][x] = now;
                        }
                    }
                }
            }
        } else if (p == 2) { // 좌
            for (int y = 0; y < n; y++) {
                int check = 0;
                for (int x = 1; x < n; x++) {
                    if (lst[y][x] != 0) {
                        int now = lst[y][x];
                        lst[y][x] = 0;
                        if (lst[y][check] == now) {
                            lst[y][check] = now * 2;
                            check += 1;
                        } else if (lst[y][check] == 0) {
                            lst[y][check] = now;
                        } else {
                            check += 1;
                            lst[y][check] = now;
                        }
                    }
                }
            }
        } else { // 우
            for (int y = 0; y < n; y++) {
                int check = n - 1;
                for (int x = n - 2; x > -1; x--) {
                    if (lst[y][x] != 0) {
                        int now = lst[y][x];
                        lst[y][x] = 0;
                        if (lst[y][check] == now) {
                            lst[y][check] = now * 2;
                            check -= 1;
                        } else if (lst[y][check] == 0) {
                            lst[y][check] = now;
                        } else {
                            check -= 1;
                            lst[y][check] = now;
                        }
                    }
                }
            }
        }
    }
}
