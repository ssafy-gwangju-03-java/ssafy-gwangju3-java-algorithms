package study_week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_9024 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [] arr = new int [n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int start = 0;
			int end = n-1;
			int sum = 0;
			int ans = Integer.MAX_VALUE;
			int cnt = 0;
			while(start < end) {
				sum = arr[start] + arr[end];
				int temp = Math.abs(k-sum);
				if(temp < ans) {
					cnt = 1;
					ans = temp;
				} else if(temp == ans) {
					cnt++;
				}
				
				if(sum <= k) {
					start++;
				}else {
					end--;
				}
				
			}
			
			System.out.println(cnt);
			
		}

	}

}
