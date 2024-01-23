import java.util.Scanner;
public class B_21_10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            } else {
                System.out.println(a+b);
            }
        }
        sc.close();
    }
}
