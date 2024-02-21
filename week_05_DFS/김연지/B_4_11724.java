package study_week5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class B_4_11724 {
    static int [] visited = new int [1001];
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < 1001; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        int cnt = 0;

        int i = 1;
        while(true){
            dfs(i);
            cnt++;
            int temp = 0;
            for(int j = 1; j <=n; j++){
                if(visited[j]==0){
                    i = j;
                }else{
                    temp++;
                }
            }
            if(temp == n){
                break;
            }
        }
        System.out.println(cnt);


    }
    public static void dfs(int v){
        visited[v] = 1;
        for(int i = 0; i < arr.get(v).size(); i++){
            if(visited[arr.get(v).get(i)]==0){
                dfs(arr.get(v).get(i));
            }
        }
    }

}
