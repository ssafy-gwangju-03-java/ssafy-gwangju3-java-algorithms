import java.util.*;
import java.io.*;

public class B_1_16916 {
    public static void main(String[] args) {
        // 시간 초과
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String P = sc.nextLine();
        if (S.indexOf(P) != -1) {
            System.out.println(1);
        } else{
            System.out.println(0);
        }

        // 시간 초과
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String S = bf.readLine();
//        String P = bf.readLine();
//
//        if (S.indexOf(P) == -1) {
//            bw.write(0+ "\n");
//        } else {
//            bw.write(1+"\n");
//        }
//        bw.flush();
//        bw.close();


    }
}
}
