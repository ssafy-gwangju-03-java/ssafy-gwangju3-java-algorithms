import java.io.*;
import java.util.*;

// 원래 답 (해시맵 사용)
public class B_3_20154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArr = s.toCharArray();
        int sum = 0;
        HashMap<Character, Integer> mp = new HashMap<>() {{
            put('A', 3);
            put('B', 2);
            put('C', 1);
            put('D', 2);
            put('E', 3);
            put('F', 3);
            put('G', 3);
            put('H', 3);
            put('I', 1);
            put('J', 1);
            put('K', 3);
            put('L', 1);
            put('M', 3);
            put('N', 3);
            put('O', 1);
            put('P', 2);
            put('Q', 2);
            put('R', 2);
            put('S', 1);
            put('T', 2);
            put('U', 1);
            put('V', 1);
            put('W', 2);
            put('X', 2);
            put('Y', 2);
            put('Z', 1);
        }};

        for (char a: charArr) {
            sum += mp.get(a);
        }

        if (sum % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }
    }

    // 다른 답 (배열 사용)
    public class AnotherAnswer {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            char[] charArr = s.toCharArray();
            int sum = 0;
    
            int arr[] = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
    
            for (int i = 0; i < s.length(); i++) {
                sum += arr[s.charAt(i)-'A'];
            }
    
            if (sum > 10) {
                sum %= 10;
            }
    
            if (sum % 2 == 0) {
                System.out.println("You're the winner?");
            } else {
                System.out.println("I'm a winner!");
            }
        }
    }
}

