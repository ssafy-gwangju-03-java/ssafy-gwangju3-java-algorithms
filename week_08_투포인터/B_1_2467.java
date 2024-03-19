package study_week8;

import java.util.Scanner;

public class B_1_2467 {
    static int min = Integer.MAX_VALUE;
    static int[]arr;
    static int x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++){
            binary(i+1, n-1, i);
        }
        System.out.println(x+" "+ y);
    }
    public static boolean binary(int start,int end, int now){
        while(start<=end){
            int mid = (start + end) / 2;
            int mix = arr[mid] + arr[now];
            if(Math.abs(mix) < min){
                min = Math.abs(mix);
                x = arr[now];
                y = arr[mid];
            }
            if(mix < 0) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
