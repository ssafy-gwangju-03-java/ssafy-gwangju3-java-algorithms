package W1;

import java.util.Scanner;

public class B_13_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        if (A > B){
            System.out.println('>');
        } else if (A < B) {
            System.out.println('<');
        } else {
            System.out.println("==");
        }
    }
}
