import java.io.*;

public class B_5_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        while (s != null) {
            String[] strArr = s.split(" ");
            StringBuilder sub = new StringBuilder(strArr[0]);
            String master = strArr[1];

            for (int i = 0; i < master.length(); i++) {
                // 백준에서는 isEmpty() 쓰면 컴파일 에러
                // 채점시에는 length() 사용
                if (!sub.isEmpty() && master.charAt(i) == sub.charAt(0)) {
                    sub.deleteCharAt(0);
                }
            }

            if (sub.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            s = br.readLine();
        }
    }
}