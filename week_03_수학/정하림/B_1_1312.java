package java_study.w3;
import java.util.Scanner;
public class B_1_1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            A = (A % B) * 10;
        }
        int result = A / B;
        System.out.println(result);

    }
}

