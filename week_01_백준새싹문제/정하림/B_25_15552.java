package W1;

import java.io.*;
import java.util.*;
import java.lang.*;

public class B_25_15552 {
    public static void main(String[] args) throws IOException {
        // Scanner : Space, Enter 모두 경계로 인식, 입력 자료형 다양
        // BufferedReader : Enter만 경계로 인식, 입력 자료형 String만

        // 빠른 입출력
        // import java.io.*
        // psvm throws IOException{코드}
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // String s = bf.readLine();
        // 정수 입력
        // int i = Integer.parseInt((bf.readLine()));
        // ※ import java.lang.*;
        // Space 단위 경계
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // ※ import java.util.*;
        // int i = Integer.parseInt(st.nextToken());
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // bw.write(s + "\n");
        // bw.flush();
        // bw.close();
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(bf.readLine());
            bw.write(Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken()) + "\n");
        }
            bw.flush();
            bw.close();

    }
}
