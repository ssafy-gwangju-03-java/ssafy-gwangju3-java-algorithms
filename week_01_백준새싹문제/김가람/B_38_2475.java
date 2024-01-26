import java.util.Scanner;

public class B_38_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            answer += (long) Math.pow(num, 2);
        }
        
        System.out.println(answer % 10);
        sc.close();
    }
}
