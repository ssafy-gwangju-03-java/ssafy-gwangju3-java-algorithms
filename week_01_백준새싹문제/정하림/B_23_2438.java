package W1;

import java.util.Scanner;

public class B_23_2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i < N+1; i++){
            for (int n = 1; n < i+1; n++){
                System.out.print('*');
            }
            System.out.println();

        }
    }
}
