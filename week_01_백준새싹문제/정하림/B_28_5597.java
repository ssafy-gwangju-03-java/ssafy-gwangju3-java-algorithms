package W1;

import java.util.Scanner;

public class B_28_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] student = new int[30];
        int S;
        for (int i = 0; i < 28; i++){
            S = sc.nextInt();
            student[S-1] = S;
        }
        for (int s = 0; s < 30; s++) {
            if (student[s] == 0) {
                System.out.println(s+1);
            }
        }

    }
}
