import java.util.Scanner;

public class B_2_16171 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S_sb = new StringBuilder(sc.next());
        String K = sc.next();
        // 숫자 제거
        for (int i = 0; i < S_sb.length();) {
            // Character.isDigit()
            int ascii;
            ascii = (int) S_sb.charAt(i);
            if ((int)'0' <= ascii && ascii <= (int) '9') {
                S_sb.deleteCharAt(i);
            } else {
                i++;
            }
        }

        String S = S_sb.toString();
        if (S.contains(K)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
