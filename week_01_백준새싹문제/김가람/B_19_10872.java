import java.util.*;
class B_19_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(1);
        } else {
            int result = 1;
            while (n != 0) {
                result *= n;
                n--;
            }
            System.out.println(result);
        }
        sc.close();
    }
} 