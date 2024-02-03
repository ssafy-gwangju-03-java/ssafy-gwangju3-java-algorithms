import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_04_4659 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String password = br.readLine();

            if (password.equals("end")) {
                break;
            }

            if (validate(password)) {
                sb.append("<"+password+">"+" is acceptable.\n");
            } else {
                sb.append("<"+password+">"+" is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean validate(String password) {
        return checkRule1(password) && checkRule2(password) && checkRule3(password);
    }

    public static boolean checkRule1(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (isVowel(c))
                return true;
        }
        return false;
    }

    public static boolean checkRule2(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String str = password.substring(i, i + 3);
            int vowel = 0;
            int consonant = 0;

            for (int j = 0; j < str.length(); j++) {
                if (isVowel(str.charAt(j)))
                    vowel++;
                else
                    consonant++;
            }
            if (vowel == 3 || consonant == 3)
                return false;
        }

        return true;
    }

    public static boolean checkRule3(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            String str = password.substring(i, i + 2);

            if (str.charAt(0) == str.charAt(1)) {
                if (!str.equals("ee") && !str.equals("oo"))
                    return false;
            }
        }

        return true;
    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}

