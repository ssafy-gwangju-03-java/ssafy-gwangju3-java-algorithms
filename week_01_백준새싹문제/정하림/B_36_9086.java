package W1;

import java.util.Scanner;
import java.lang.*;

public class B_36_9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            String str = sc.next();
            System.out.print(str.charAt(0));
            System.out.println(str.charAt(str.length() - 1));
        }



    }
}
