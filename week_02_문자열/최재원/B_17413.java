import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        String str = br.readLine();

        boolean isInBracket = false;

        for (int i = 0; i < str.length(); i++) {
            // 첫 글자에서 '<'를 만나면 <를 포함해서 만났던 문자열을 결과에 거꾸로 저장하고 괄호 안임을 표시
            if (str.charAt(i) == '<' && i == 0) {
                isInBracket = true;

                temp.append(str.charAt(i));
                result.append(temp.reverse());

                temp.setLength(0);
            }
            // 첫 글자가 아닌 '<'를 만나면 지금까지 <를 제외한 이전에 만났던 문자열을 결과에 거꾸로 저장하고 괄호 안임을 표시 후 temp에 < 저장
            else if (str.charAt(i) == '<' && i != 0) {
                isInBracket = true;

                result.append(temp.reverse());
                temp.setLength(0);

                temp.append(str.charAt(i));
            }
            // '>'를 만나면 지금까지 만났던 문자열을 결과에 저장하고 괄호 밖임을 표시
            else if (str.charAt(i) == '>') {
                isInBracket = false;
                temp.append(str.charAt(i));
                result.append(temp);
                temp.setLength(0);
            }
            // 괄호 안에서 공백을 만나면
            else if (str.charAt(i) == ' ' && isInBracket) {
                // temp에 그대로 추가
                temp.append(str.charAt(i));
            }
            // 괄호 밖에서 공백을 만나면
            else if (str.charAt(i) == ' ' && !isInBracket) {
                // temp를 뒤집어서 결과에 붙이고 결과에 공백 추가
                result.append(temp.reverse());
                result.append(' ');
                temp.setLength(0);
            }
            // 괄호 안 문자거나 괄호 밖 문자면
            else {
                temp.append(str.charAt(i));
            }

            // 문자열이 '>'가 아닌 문자로 종료되면
            if (i == str.length() - 1 && str.charAt(i) != '>') {
                // temp를 결과에 뒤집어서 붙이기
                result.append(temp.reverse());
                temp.setLength(0);
            }
        }

        System.out.println(result);
    }
}
