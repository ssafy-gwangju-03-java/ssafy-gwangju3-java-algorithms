import java.util.*;
public class B_4_4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v = "aeiou";

        while (true) {
            String password = sc.next();
            String[] p = password.split("");
            int result = 0;

            // end
            if (password.equals("end")) {
                break;
            }
            //1. 모음(a,e,i,o,u) 하나 이상
            result++;
            for (String word : p) {
                if (v.contains(word)) {
                    result--;
                    break;
                }
            }
            //2. 모음/자음이 3개 연속X
            for (int i = 0; i < (p.length - 2); i++) {
                if (v.contains(p[i]) && v.contains(p[i+1]) && v.contains(p[i+2])) {
                    result++;
                    break;
                }
                if (!v.contains(p[i]) && !v.contains(p[i+1]) && !v.contains(p[i+2])) {
                    result++;
                    break;
                }
            }
            // 3. 같은 글자가 연속적으 두번X
            for (int i = 0; i < (p.length - 1); i++) {
                if (p[i].equals(p[i + 1])) {
                    if (!p[i].equals("e") && !p[i].equals("o")) {
                        result++;
                        break;
                    }
                }
            }
            if (result == 0) {
                System.out.printf("<%s> is acceptable.\n", password);
            }
            else {
                System.out.printf("<%s> is not acceptable.\n", password);
            }
        }
    }
}