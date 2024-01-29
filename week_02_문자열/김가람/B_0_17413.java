import java.util.Scanner;

public class B_0_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int leftIdx = -1;
        int rightIdx = -1;

        StringBuilder result = new StringBuilder(s.length());
        StringBuilder wrd = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                leftIdx = i;
                result.append(wrd.reverse());
                wrd.setLength(0);
            } else if (s.charAt(i) == '>') {
                rightIdx = i;
                result.append(s, leftIdx, i + 1);
            } else if (rightIdx > leftIdx || (rightIdx < 0 && leftIdx < 0)) {
                if (s.charAt(i) == ' ') {
                    result.append(wrd.reverse().append(' '));
                    wrd.setLength(0);
                } else {
                    wrd.append(s.charAt(i));
                    if (i == s.length() - 1) {
                        result.append(wrd.reverse());
                    }
                }
            }
        }
        System.out.println(result.toString());
    }
}
