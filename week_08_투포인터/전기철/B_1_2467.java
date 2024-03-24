package week_08_투포인터.전기철;

import java.util.Scanner;

public class B_1_2467 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[] lst=new int[n];
        String[] x= sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
          lst[i]=Integer.parseInt(x[i]);
        }
        int chk=2000000001;
        int start=0;
        int end=n-1;
        int[] save=new int[2];
        while (start<end) {
            int sm=lst[start]+lst[end];
            if(sm==0){
                save[0]=lst[start];
                save[1]=lst[end];
                break;
            }
            if(Math.abs(chk)>Math.abs(sm)){
              chk=sm;
              save[0]=lst[start];
              save[1]=lst[end];
            }
            if(sm>0){
              end-=1;
            }
            else{
              start+=1;
            }
        }
        System.out.print(save[0]);
        System.out.print(" ");
        System.out.println(save[1]);
        sc.close();
    }

}
