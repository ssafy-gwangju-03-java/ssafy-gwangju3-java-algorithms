package study_week8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_5_1450 {
    static int[][] dp;
    static int[] arr;
    static int n, c, cnt;
    static List<Integer> left;
    static List<Integer> right;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n];
        cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        comb(0, n / 2, left, 0);
        comb(n / 2, n, right, 0);
        right.sort((a,b) -> (a-b));


        int cnt = 0;
        int idx = 0;
        for(int i =0; i < left.size(); i++){
            idx = upperbound(0,right.size()-1,left.get(i));
            cnt += idx+1;
        }
        System.out.println(cnt);


    }

    public static int upperbound(int s, int e, int v) {
        while(s<=e){
            int mid = (s+e)/2;
            if(right.get(mid) <= c - v){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return e;
    }

    public static void comb(int n, int idx, List<Integer> selected, int check) {
        if (check > c) return;
        if (n == idx) {
            selected.add(check);
            return;
        }
        comb(n + 1, idx, selected, check);
        comb(n + 1, idx, selected, check + arr[n]);
    }

}
