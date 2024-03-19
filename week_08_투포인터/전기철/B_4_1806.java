package week_08_투포인터.전기철;

import java.util.Scanner;

public class B_4_1806 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] lst = new int[n];
        for(int i=0;i<n;i++){
            lst[i]=Integer.parseInt(s[i]);
        }
        int end=0;
        int sum=0;
        int cnt=10000*100000+1;
        for(int i=0;i<n;i++){
            while (sum<m &&end<n) {
                sum+=lst[end];
                end+=1;
            }
            if(sum>=m){
                cnt=Math.min(cnt,end-i);
            }
            sum-=lst[i];

        }
        if (cnt==10000*100000+1){
            System.out.println(0);
        }
        else{
            System.out.println(cnt);
        }
    }
}
