import java.util.Scanner;
public class B_24_10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a+b);
        }
        sc.close();
    }
}
