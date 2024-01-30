// 백준 16171 나는 친구가 적다 (Small)

import java.util.Scanner;
public class B_2_16171 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringBuilder sb = new StringBuilder(s1);
        sc.close();

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
            }
        }
        
        if (sb.indexOf(s2) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}