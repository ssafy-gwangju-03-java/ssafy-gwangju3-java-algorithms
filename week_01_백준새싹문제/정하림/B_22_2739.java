package W1;

import java.util.Scanner;

public class B_22_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i < 10; i++){
            System.out.printf("%d * %d = %d", N, i, N * i);
            System.out.println();
        }
    }
}
