import java.util.Scanner;
public class B_17_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(Math.abs(n-m));
        sc.close();
    }
}
