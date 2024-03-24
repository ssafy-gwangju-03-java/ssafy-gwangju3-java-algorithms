package java_study.w8;
//import java.io.*;
//import java.lang.*;
//import java.util.*;
//
//
public class B_4_1806 {
//    static int N, SUM;
//    static int[] seq;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        SUM = Integer.parseInt(st.nextToken());
//        seq = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            seq[i] = Integer.parseInt(st.nextToken());
//        }
//        System.out.println(sub(0, 1));
//    }
//
//    public static int sub(int s, int e) {
//        int sum = 0;
//        int d = 1;
//        while (d <= N) {
//            sum = 0;
//            for (int i = s; i < e; i++) {
//                sum += seq[i];
//            }
//            if (sum >= SUM) return e-s;
//            s++;
//            e++;
//            if (e > N) {
//                d++;
//                s = 0;
//                e = s+d;
//            }
//        }
//        return 0;
//    }
}
////package java_study.w8;
////import java.io.*;
////import java.lang.*;
////import java.util.*;
////
////
////public class B_4_1806 {
////    static int N, SUM;
////    static int[] seq;
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st;
////
////        st = new StringTokenizer(br.readLine());
////        N = Integer.parseInt(st.nextToken());
////        SUM = Integer.parseInt(st.nextToken());
////        seq = new int[N];
////        st = new StringTokenizer(br.readLine());
////        for (int i = 0; i < N; i++) {
////            seq[i] = Integer.parseInt(st.nextToken());
////        }
////        System.out.println(sub(0, 1));
////    }
////
////    public static int sub(int s, int e) {
////        int sum = 0;
////        int d = 1;
////        while (d <= N) {
////            sum = 0;
////            for (int i = s; i < e; i++) {
////                sum += seq[i];
////            }
////            if (sum >= SUM) return e-s;
////            s++;
////            e++;
////            if (e > N) {
////                d++;
////                s = 0;
////                e = s+d;
////            }
////        }
////        return 0;
////    }
////}
//
////package java_study.w8;
////import java.io.*;
////import java.lang.*;
////import java.util.*;
////
////
////public class B_4_1806 {
////    static int N, SUM;
////    static int[] seq;
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st;
////
////        st = new StringTokenizer(br.readLine());
////        N = Integer.parseInt(st.nextToken());
////        SUM = Integer.parseInt(st.nextToken());
////        seq = new int[N];
////        st = new StringTokenizer(br.readLine());
////        for (int i = 0; i < N; i++) {
////            seq[i] = Integer.parseInt(st.nextToken());
////        }
////        int ans = sub(0, 1);
////        System.out.println(ans);
////    }
////
////    public static int sub(int s, int d) {
////        int sum = 0;
////        while (true) {
////            if (sum >= SUM) break;
////            if (s == 1 && d == N) return 0;
////            if (s + d > N) {
////                s = 0;
////                d++;
////                continue;
////            }
////
////            sum = 0;
////            for (int i = s; i < s + d; i++) {
////                sum += seq[i];
////            }
////
////            s++;
////        }
////        return d;
////    }
////}