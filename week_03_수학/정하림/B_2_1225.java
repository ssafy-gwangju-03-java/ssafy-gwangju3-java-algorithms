package java_study.w3;
import java.util.Scanner;

public class B_2_1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.next().split("");
        String[] B = sc.next().split("");
        long total = 0 ;
        for (String a : A) {
            for (String b : B) {
                total += Integer.parseInt(a) * Integer.parseInt(b);
            }
        }
        System.out.println(total);

    }
}

