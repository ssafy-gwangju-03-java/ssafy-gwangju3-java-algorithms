import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_05_6550 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        while (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            String t = st.nextToken();

            if (isSubString(s, t)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }

            line = br.readLine();
        }

        System.out.println(sb);
    }

    private static boolean isSubString(String s, String t) {
        int count = 0;
        String comparator = t;

        for (int i = 0; i < s.length(); i++) {
            int j = 0;

            while (true) {
                if (s.charAt(i) == comparator.charAt(j)) {
                    count += 1;
                    if (count == s.length()) {
                        return true;
                    }

                    comparator = comparator.substring(j + 1);
                    break;
                }

                j += 1;

                if (j == comparator.length()) {
                    return false;
                }
            }
        }

        return false;
    }
}
