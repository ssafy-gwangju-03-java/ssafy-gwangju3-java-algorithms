package W1;

import java.util.Scanner;

public class B_26_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] A = new int[N];
        for (int idx = 0; idx < N; idx++){
            A[idx] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] < X) {
                if (count == 0) {
                    System.out.printf("%d", A[i]);
                    count++; // 배열에 값을 추가하거나 한 칸 씩 띄는 방법을 몰라서
                } else {
                    System.out.printf(" %d", A[i]);
                }
            }
        }

    }
}
