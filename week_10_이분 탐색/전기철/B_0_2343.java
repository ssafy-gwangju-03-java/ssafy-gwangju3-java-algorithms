import java.util.Scanner;
public class B_0_2343 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] lst=new int[n];
        for(int i=0;i<n;i++){
            lst[i]=sc.nextInt();
        }
        int mx=0;
        int sm=0;
        for(int i=0;i<n;i++){
            sm+=lst[i];
            mx=Math.max(mx,lst[i]);
        }
        int start=mx;
        int end=sm;
        while (start<=end) {
            int mid=(start+end)/2;
            int first=0;
            int cnt=0;
            for(int i=0;i<n;i++){
                if(first+lst[i]>mid){
                    first=0;
                    cnt+=1;
                }
                first+=lst[i];
            }
            if(first!=0){
                cnt+=1;
            }
            if(cnt>m){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
            
        }
        System.out.println(start);
        sc.close();
    }
}
