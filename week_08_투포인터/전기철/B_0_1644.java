package week_08_투포인터.전기철;

import java.util.Scanner;

public class B_0_1644 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        boolean[] era= new boolean[n+1];
        for (int i=0;i<n+1;i++){
            era[i]=true;
        }

        double x= (double) n;
        int c= (int) Math.floor(Math.sqrt(x));
        for(int i=2;i<c+1;i++){
            if(era[i]==true){
                for(int j=2*i;j<n+1;j+=i){
                    era[j]=false;
                }
            }
        }
        int[] b= new int[n+1];
        int cont=0;
        for(int i=2;i<n+1;i++){
            if (era[i]==true){
                b[cont]=i;
                cont++;
            }
        }
        int length = cont;
        int start=0;
        int end=0;
        int cnt=0;
        while(start<length && end<length){
            int chk=0;
            for(int i=start;i<end+1;i++){
                chk+=b[i];
            }
            if(chk==n){
                cnt++;
            }
            if (chk>n){
                start+=1;
            }
            else{
                end+=1;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
