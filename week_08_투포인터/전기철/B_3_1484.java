package week_08_투포인터.전기철;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_3_1484 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int start=1;
        int end=1;
        Queue<int[]> q=new LinkedList<>();
        while (start<n &&end<n) {
            if(end*end-start*start==n){
                q.add(new int[]{end});
            }
            if(end*end-start*start<n){
                end+=1;
            }
            else{
                start+=1;
            }
        }
        if(!q.isEmpty()){
            while (!q.isEmpty()) {
                int[] x=q.poll();
                System.out.println(x[0]);
            }
        }
        else{
            System.out.println(-1);
        }
        sc.close();
    }
}
