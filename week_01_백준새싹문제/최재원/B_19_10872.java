import java.util.Scanner;

public class B_19_10872 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        System.out.println(factorial(num));
    }

    public static int factorial(int num) {
        if(num <= 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
