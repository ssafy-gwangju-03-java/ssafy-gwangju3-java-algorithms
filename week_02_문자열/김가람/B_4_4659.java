import java.io.*;
import java.util.*;

public class B_4_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String s = br.readLine();

        boolean isValid;
        boolean hasVowel;
        int vowCheck ;
        int consCheck;

        while (!s.equals("end")) {
            // 문자열 입력시마다 초기화
            isValid = true;
            hasVowel = false;
            vowCheck = 0;
            consCheck = 0;

            // 길이 1 문자열
            if (s.length() == 1) {
                if (vowels.contains(s.charAt(0))) {
                    hasVowel = true;
                }
            } else { // 그외 모든 길이 문자열
                for (int i = 0; i < s.length(); i++) {
                    char curr = s.charAt(i);
                    char prev = 'A'; // Dummy char, 비밀번호는 소문자만 사용
                    if (i > 0) {
                        prev = s.charAt(i-1);
                    }

                    // 1. 모음 반드시 하나 포함
                    if (vowels.contains(curr)) {
                        hasVowel = true;
                    // 2. 모음 혹은 자음이 연속 3개로 오면 안됨
                        vowCheck += 1;
                        consCheck = 0;
                    } else {
                        consCheck += 1;
                        vowCheck = 0;
                    }

                    // 연속 여부 체크
                    if (vowCheck == 3 || consCheck == 3) {
                        isValid = false;
                        break;
                    }

                    // 3. 같은 글자가 연속적으로 두번 오면 안되나 ee와 oo는 허용
                    if (curr == prev && curr != 'e' && curr != 'o') {
                        isValid = false;
                        break;
                    }
                }
            }
            // 최종 validation
            if (isValid && hasVowel) {
                System.out.printf("<%s> is acceptable.\n", s);
            } else {
                System.out.printf("<%s> is not acceptable.\n", s);
            }
            s = br.readLine();
        }
    }
}