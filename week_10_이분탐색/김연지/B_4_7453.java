package study_week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_4_7453 {
	static int n;
	static long total;
	static int[][]arr;
	static int[]ab;
	static int[]cd;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[4][n];

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}

		}
		
		ab = new int[n*n];
		cd = new int[n*n];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ab[idx] = arr[0][i]+arr[1][j];
				cd[idx] = arr[2][i]+arr[3][j];
				idx++;
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		find();
		
		System.out.println(total);

	}
	static void find() {
		int start = 0;
		int end = n*n-1;
		
		while(start<n*n && end>=0) {
			long left = ab[start];
			long right = cd[end];
			long sum = left+right;
			
			if(sum < 0) {
				start++;
			} else if(sum > 0) {
				end--;
			} else {
				long lcnt = 0;
				long rcnt = 0;
				while(start <= n*n && (left == ab[start])) {
					lcnt++;
					start++;
				}
				while(end>=0 && (right == cd[end])) {
					rcnt++;
					end--;
				}
				total += lcnt * rcnt;
			}
		}
	}
	

}
