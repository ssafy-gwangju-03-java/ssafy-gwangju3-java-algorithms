import java.util.Scanner;

public class B_5_6550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] s = sc.next().split("");
            String t = sc.next();
            String result = "Yes";

            for (String ss : s) {
                if (!t.contains(ss)) {
                    result = "No";
                    break;
                } else {
                    t = t.substring(t.indexOf(ss)+1);
                }
            }
            System.out.println(result);
        }
    }
}
