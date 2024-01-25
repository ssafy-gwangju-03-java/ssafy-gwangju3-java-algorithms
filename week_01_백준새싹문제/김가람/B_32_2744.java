import java.io.IOException;
import java.util.Scanner;

public class B_32_2744 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String answer = "";

        for (char x: str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);
            } else {
                answer += Character.toLowerCase(x);
            }
        }

        System.out.println(answer);
    }
}
