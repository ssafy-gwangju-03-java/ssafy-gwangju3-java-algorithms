package W1;

import java.util.Scanner;

public class B_27_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] n = new int[N];
        for (int i =0; i < N; i++) {
            n[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int count = 0;
        for (int i =0; i < N; i++) {
            if (n[i] == v) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
