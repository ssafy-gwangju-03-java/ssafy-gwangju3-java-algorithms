package study_week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_0_2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N];
		int[] check = new int[d + 1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 1;
		check[c]++;
		for (int i = 0; i < k; i++) {
			if (check[sushi[i]] == 0)
				cnt++;
			check[sushi[i]]++;
		}

		int count = cnt;
		for (int i = 1; i < N; i++) {
			int p = sushi[i - 1];
			check[p]--;
			if (check[p] == 0)
				count--;

			int add = sushi[(i + k - 1) % N];
			if (check[add] == 0)
				count++;
			check[add]++;

			cnt = Math.max(cnt, count);
		}

		System.out.println(cnt);

	}

}
