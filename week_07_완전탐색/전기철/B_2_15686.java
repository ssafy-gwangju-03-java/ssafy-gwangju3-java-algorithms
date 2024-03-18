import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lst = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lst[i][j] = sc.nextInt();
            }
        }

        ArrayList<int[]> house = new ArrayList<>();
        ArrayList<int[]> chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lst[i][j] == 1) {
                    house.add(new int[]{j, i});
                } else if (lst[i][j] == 2) {
                    chicken.add(new int[]{j, i});
                }
            }
        }

        int ans = 10000000;
        ArrayList<ArrayList<int[]>> chickenCombi = new ArrayList<>();
        combination(chicken, new ArrayList<int[]>(), 0, m, chickenCombi);

        for (ArrayList<int[]> combination : chickenCombi) {
            int mn = 0;
            for (int[] j : house) {
                int chk = 101;
                for (int[] k : combination) {
                    chk = Math.min(chk, Math.abs(k[0] - j[0]) + Math.abs(k[1] - j[1]));
                }
                mn += chk;
            }
            ans = Math.min(ans, mn);
        }
        System.out.println(ans);
        sc.close();
    }

    public static void combination(ArrayList<int[]> list, ArrayList<int[]> temp, int start, int r, ArrayList<ArrayList<int[]>> result) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            temp.add(list.get(i));
            combination(list, temp, i + 1, r, result);
            temp.remove(temp.size() - 1);
        }
    }
}