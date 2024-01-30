import java.util.Scanner;

public class B_2_16171 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String K = sc.next();
        StringBuilder sb;
        // 숫자 제거
        for (int i = 0; i < S.length();) {
            int ascii;
            ascii = (int) S.charAt(i);
            if ((int)'0' <= ascii && ascii <= (int) '9') {
                sb = new StringBuilder(S);
                sb.deleteCharAt(i);
                S = sb.toString();
            } else {
                i++;
            }
        }
        // 포함 여부
        if (S.contains(K)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
