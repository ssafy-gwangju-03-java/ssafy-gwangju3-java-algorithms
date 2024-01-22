package W1;

import java.util.Scanner;

public class B_11_1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        System.out.printf("%.9f", (double) A/B);
        // float 사용 시 오류.. 왜..?
    }
}
