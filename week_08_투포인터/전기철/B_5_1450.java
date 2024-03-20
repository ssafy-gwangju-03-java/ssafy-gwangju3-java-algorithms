package week_08_투포인터.전기철;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B_5_1450 {
    static int[] lst1;
    static int[] lst2;
    static int n, c;
    static List<Integer> ans1;
    static List<Integer> ans2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        lst1 = new int[n / 2];
        lst2 = new int[n / 2 + n % 2];
        ans1 = new LinkedList<>();
        ans2 = new LinkedList<>();
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n / 2; i++) {
            lst1[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < lst2.length; i++) {
            lst2[i] = Integer.parseInt(s[i + n / 2]);
        }
        bag(lst1, 0, 0);
        bag2(lst2, 0, 0);
        int[] ans = new int[ans2.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans2.get(i);
        }
        Arrays.sort(ans);
        int cnt = 0;
        for (int i = 0; i < ans1.size(); i++) {
            int x = ans1.get(i);
            cnt += upperbound(ans, c - x);
        }
        System.out.println(cnt);
        sc.close();
    }

    public static void bag(int[] lst, int x, int cnt) {
        if (x > c) {
            return;
        }
        if (cnt == lst.length) {
            ans1.add(x);
            return;
        }
        bag(lst, x + lst[cnt], cnt + 1);
        bag(lst, x, cnt + 1);
    }

    public static void bag2(int[] lst, int x, int cnt) {
        if (x > c) {
            return;
        }
        if (cnt == lst.length) {
            ans2.add(x);
            return;
        }
        bag2(lst, x + lst[cnt], cnt + 1);
        bag2(lst, x, cnt + 1);
    }

    public static int upperbound(int[] lst, int target) {
        int start = 0;
        int end = lst.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= lst[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
