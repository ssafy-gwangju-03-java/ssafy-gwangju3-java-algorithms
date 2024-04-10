import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4_10775 {
    static int G, P;
    static int[] p;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_11_유니온파인드/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        p = makeSet();

        int answer = 0;

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());

            int gate = findSet(g);

            // 남은 게이트가 없으면 종료
            if (gate == 0) {
                break;
            // 있으면 다음 번 빈 게이트가 대표자가 되도록 합치기
            } else {
                answer += 1;
                union(gate, gate - 1);
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        p[a] = b;
    }

    static int findSet(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = findSet(p[x]);
    }

    static int[] makeSet() {
        int[] arr = new int[G + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return arr;
    }
}
