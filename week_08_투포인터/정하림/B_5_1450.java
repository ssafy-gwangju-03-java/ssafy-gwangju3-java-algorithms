package java_study.w8;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
public class B_5_1450 {
//    static int N, C;
//    static List<Integer> W1 = new ArrayList<>();
//    static List<Integer> W2 = new ArrayList<>();
//    static Map<Integer, Integer> sum1 = new HashMap<>();
//    static Map<Integer, Integer> sum2 = new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            if (i < N / 2) W1.add(Integer.parseInt(st.nextToken()));
//
//            else W2.add(Integer.parseInt(st.nextToken()));
//        }
//        subSum(W1, 0, 0, sum1);
//        subSum(W2, 0, 0, sum2);
//
//        int cnt = 0;
//        for (Integer s1 : sum1.keySet()) {
//            for (Integer s2 : sum2.keySet()) {
//                if (s1 + s2 <= C) {
//                    cnt += sum1.get(s1) * sum2.get(s2);
//                }
//            }
//        }
//
//        System.out.println(cnt);
//
//
//
//
//    }
//
//
//    public static void subSum(List<Integer> W12, int idx, int now_sum, Map<Integer, Integer> sum12) {
//        if (now_sum > C) return;
//        if (idx == W12.size()) {
//            sum12.put(now_sum, sum12.getOrDefault(now_sum, 0)+1);
//            return;
//        }
//        subSum(W12,idx + 1, now_sum + W12.get(idx), sum12);
//        subSum(W12, idx + 1, now_sum, sum12);
//
//    }
}
