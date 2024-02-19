import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] hap = new int[10];
        hap[0] = 1;
        hap[1] = 2;
        hap[2] = 4;

        for (int i = 3; i < 10; i++) {
            hap[i] = hap[i-1] + hap[i-2] + hap[i-3];
        }

        for (int t = 0; t < T; t++) {
            int p = Integer.parseInt(br.readLine());
            System.out.println(hap[p-1]);
        }
    }
}