package java_study.w3;

import java.util.Scanner;

public class B_4_2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 현재 나무
        int KOI1 = sc.nextInt(), KOI2;
        int[] diff = new int[N - 1];
        for (int i = 0; i < (N-1); i++) {
            KOI2 = sc.nextInt();
            diff[i] = KOI2 - KOI1;
            KOI1 = KOI2;
        }
        // 최대공약수
        int a = diff[0], b = diff[1];
        for (int i = 2; i < diff.length; i++) {
            a = gcd(a, b);
            b = diff[i];
        }
        int GCD = gcd(a, b);
        // 새로 심기
        int new_tree = 0;
        for (int i = 0; i < (N-1); i++) {
            new_tree += diff[i] / GCD -1;
        }
        System.out.println(new_tree);

    }
    // gcd
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
