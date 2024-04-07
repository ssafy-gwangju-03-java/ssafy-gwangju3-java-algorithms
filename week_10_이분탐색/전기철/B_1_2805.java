import java.util.Scanner;

public class B_1_2805{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] lst=new int[n];
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            lst[i]=sc.nextInt();
            end=Math.max(lst[i],end);
        }
        while (start<=end) {
            long cnt=0;
            int mid=(start+end)/2;
            for(int i=0;i<n;i++){
                if(lst[i]>mid){
                    cnt+=lst[i]-mid;
                }
            }
            if(cnt<m){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        System.out.println(end);
    }
}