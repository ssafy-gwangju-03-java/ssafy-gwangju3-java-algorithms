package W1;

import java.util.Scanner;

public class B_21_10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A == 0 && B == 0) {
                break;
            } else {
                System.out.println(A+B);
            }
        }
    }
}
