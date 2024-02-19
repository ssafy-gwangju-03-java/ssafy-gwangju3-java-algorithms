package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b2606 {
	
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int[] visited = new int [101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0; i < 101; i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		
		int cnt = 0;
		dfs(1);
		for(int i = 0; i < n+1; i++) {
			if(visited[i]==1) {
				cnt++;
			}
		}
		System.out.println(cnt-1);
		
	}
	
	public static void dfs(int v) {
		visited[v] = 1;
		
		for(int i = 0; i < arr.get(v).size(); i++) {
			if(visited[arr.get(v).get(i)]==0) {
				dfs(arr.get(v).get(i));
			}
		}
		
	}

}
