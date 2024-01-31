import java.util.Scanner;

public class B_3_20154 {
    public static void main(String[] args) {
        String ABC = "A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ".replace("\t", "");
        String num = "3\t2\t1\t2\t3\t3\t3\t3\t1\t1\t3\t1\t3\t3\t1\t2\t2\t2\t1\t2\t1\t1\t2\t2\t2\t1".replace("\t", "");

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
//
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (num.charAt(ABC.indexOf(S.charAt(i))) % 2 == 1) {
                count++;
            }
        }
        if (count % 2 == 1) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
//

// 오류 이유 찾기 
//        int sum = 0;
//        for (int i = 0; i < S.length(); i++) {
//
//             sum += num.charAt(ABC.indexOf(S.charAt(i)))
//        }
//        if (sum % 2 == 1) {
//            System.out.println("I'm a winner!");
//        } else {
//            System.out.println("You're the winner?");
//        }
//
    }
}
