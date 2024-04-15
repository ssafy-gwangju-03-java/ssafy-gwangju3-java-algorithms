package week_11_유니온파인드.전기철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_3_1043 {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        p= new int[n+1];
        List<int[]> lst=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            p[i]=i;
        }
        int result=0;
        int num_lie=sc.nextInt();
        if (num_lie==0){
            System.out.println(m);
        }
        else{
            for(int i=0;i<num_lie;i++){
                int x=sc.nextInt();
                union(0, x);
            }
            sc.nextLine();
            for(int i=0;i<m;i++){
                String[] party=sc.nextLine().split(" ");
                int size=Integer.parseInt(party[0]);
                int[] temp=new int[size+1];
                for (int k=0;k<size+1;k++){
                    temp[k]=Integer.parseInt(party[k]);
                }
                lst.add(temp);
                if(size!=1){
                    for(int j=1;j<party.length-1;j++){
                        union(Integer.parseInt(party[j]),Integer.parseInt(party[j+1]));
                    }
                }
            }
            for(int[] i:lst){
                int chk=0;
                // System.out.println(Arrays.toString(i));
                for(int j=1;j<i.length;j++){
                    if(findset(i[j])!=0){
                        chk+=1;
                    }
                }
                if(chk==i.length-1){
                    result+=1;
                }
            }
            System.out.println(result);
        }


        
    }
    static void union(int a, int b) {
        int pa = findset(a);
        int pb = findset(b);
        if (pa == pb) {
            return;
        } else {
            if (pb>pa){
                p[pb]=pa;
            }
            else{
                p[pa]=pb;
            }
        }
    }

    static int findset(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = findset(p[a]);
    }
}
