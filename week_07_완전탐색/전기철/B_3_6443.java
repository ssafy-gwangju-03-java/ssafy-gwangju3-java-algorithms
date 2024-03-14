import java.util.Scanner;

public class Main {
    static int n;
    static int[] lst;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < n; t++) {
            lst = new int[26];
            int cnt=0;
            String x = sc.nextLine();
            for (char c : x.toCharArray()) {
                lst[c - 'a']+=1;
                cnt+=1;
            }
            cal(lst, "",cnt);
        }
        sc.close();
    }

    public static void cal(int[] lst, String ans,int cnt) {
        if (cnt == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (lst[i] > 0) {
                lst[i]--;
                cal(lst, ans + (char) (i + 'a'),cnt-1);
                lst[i]++;
            }
        }
    }
}