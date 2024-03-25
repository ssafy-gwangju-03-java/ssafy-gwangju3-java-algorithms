import java.io.*;
import java.util.*;

public class B_5_1450 {
    static int N, C;
    static int[] arr;
    static List<Integer> left, right;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_08_투포인터/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        left = new ArrayList<>();
        right = new ArrayList<>();

        subset(left, 0, N / 2, 0);
        subset(right, N / 2, N, 0);

        right.sort(Comparator.comparingInt(a -> a));

        int cnt = 0;

        for (int i = 0; i < left.size(); i++) {
            int idx = upperbound(0, right.size() - 1, left.get(i));
            cnt += idx + 1;
        }

        System.out.println(cnt);
    }

    static int upperbound(int s, int e, int val) {
        while (s <= e) {
            int mid = (s + e) / 2;

            if (right.get(mid) <= C - val) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return e;
    }

    static void subset(List<Integer> list, int start, int end, int sum) {
        if (sum > C) return;

        if (start == end) {
            list.add(sum);
            return;
        }

        subset(list, start + 1, end, sum);
        subset(list, start + 1, end, sum + arr[start]);
    }
}
