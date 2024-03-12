package study_week7;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1_2961 {
    static int [] arr;
    static int [][]food;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        food = new int[n][2];
        arr = new int[n];
        boolean []visited = new boolean[n];
        for(int i = 0; i < n; i++){
            food[i][0] = sc.nextInt();
            food[i][1] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        powerSet(arr,visited,n,0);
        System.out.println(min);
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            sub(arr,visited,n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }


    static void sub(int[]arr,boolean[]visited,int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i]==true){
                temp.add(arr[i]);
            }
        }
        int sour = 1;
        int bitter = 0;
        for(int i = 0; i < temp.size(); i++){
            int k = temp.get(i);
            sour = sour * food[k][0];
            bitter = bitter + food[k][1];
        }

        int minus = Math.abs(sour-bitter);
        if(sour!=1 && bitter!=0){
        if(minus < min){
            min = minus;
        }
        }
    }
}
