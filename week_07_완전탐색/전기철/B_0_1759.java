package week_07_완전탐색.전기철;

import java.util.Arrays;
import java.util.Scanner;

public class B_0_1759 {
    static int l,c;
    static String[] s;
    static String[] mo={"a","e","i","o","u"};
    static String[] arr;
    static int[] vis;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        l=sc.nextInt();
        c=sc.nextInt();
        sc.nextLine();
        s=new String[c];
        String[] x =sc.nextLine().split(" ");
        for(int i=0;i<c;i++){
            s[i]=x[i];
        }
        vis= new int[c];
        Arrays.sort(s);
        arr=new String[l];

        combi(0,0);

        sc.close();
    }

    public static void combi(int idx,int start){
        if (idx==l){
            // System.out.println(Arrays.toString(arr));
            int cntm=0;
            int cntj=0;
            for(int i=0;i<l;i++){
                int chk=0;
                for(int j=0;j<5;j++){
                    if (arr[i].equals(mo[j])){
                        chk=1;
                        break;
                    }
                }
                if (chk==1){
                    cntm+=1;
                }
                else{
                    cntj+=1;
                }

            }
            if(cntm>=1 && cntj>=2){
                for(int i=0;i<l;i++){
                    System.out.print(arr[i]);

                }
                System.out.println();
            }

            return;
        }
        for(int i=start;i<c;i++){
            if(vis[i]==0){
                vis[i]=1;
                arr[idx]=s[i];
                combi(idx+1,i+1);
                vis[i]=0;
            }
        }
    }
    
}
