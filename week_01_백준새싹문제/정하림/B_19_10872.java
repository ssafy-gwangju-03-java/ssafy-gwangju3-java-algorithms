package W1;

import java.util.Scanner;

public class B_19_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = 1;
        for (int i = 1; i < N+1; i++){
            F *= i;
        }
        System.out.println(F);
    }
}
