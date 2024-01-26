import java.util.Scanner;
public class B_36_9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            System.out.print(s.charAt(0));
            System.out.println(s.charAt(s.length()-1));
        }
    }
}
