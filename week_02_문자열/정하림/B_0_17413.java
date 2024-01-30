import java.util.Scanner;

public class B_0_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb ;
        while (s.length() != 0) {
            if (s.charAt(0) == '<') {
                System.out.print(s.substring(0, s.indexOf(">") + 1));
                s = s.substring(s.indexOf(">") + 1);
                continue;
            }
            if (s.contains("<")) {
                sb = new StringBuilder(s.substring(0, s.indexOf("<")));
                String[] reverse_list = sb.toString().split(" ");
                for (int idx = 0; idx < reverse_list.length; idx++) {
                    sb = new StringBuilder(reverse_list[idx]);
                    sb.reverse();
                    System.out.print(sb.toString());
                    if (idx != reverse_list.length - 1) {
                        System.out.print(" ");
                    }
                }
                s = s.substring(s.indexOf("<"));
            } else {
                sb = new StringBuilder(s);
                String[] reverse_list = sb.toString().split(" ");
                for (int idx = 0; idx < reverse_list.length; idx++) {
                    sb = new StringBuilder(reverse_list[idx]);
                    sb.reverse();
                    System.out.print(sb.toString());
                    if (idx != reverse_list.length - 1) {
                        System.out.print(" ");
                    }
                }
                s = "";
            }
        }
    }
}

