import java.util.Arrays;
import java.util.Scanner;

public class B_2_3020 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int h=sc.nextInt();
        int[] lst=new int[h];
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            if(i%2==0){
                lst[h-x]+=1;
            }
            else{
                lst[0]+=1;
                lst[x]-=1;
            }

        }
        int[] prefix=new int[h+1];
        for(int i=0;i<h;i++){
            prefix[i+1]=prefix[i]+lst[i];
        }
        Arrays.sort(prefix);
        System.out.print(prefix[1]);
        System.out.print(" ");
        int ans=upperBound(prefix,prefix[1])-lowerBound(prefix, prefix[1]);
        if (prefix[1]==0){
            System.out.println(ans-1);
        }
        else{
            System.out.println(ans);
        }
    }
    public static int lowerBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < key) l = m + 1;
            else r = m;
        }
        return r;
    }
    public static int upperBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= key) l = m + 1;
            else r = m;
        }
    return r;
    }
}
