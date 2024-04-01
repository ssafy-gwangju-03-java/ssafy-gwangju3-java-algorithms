import java.util.Arrays;
import java.util.Scanner;

public class B_0_2110{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int[] lst=new int[n];
        for(int i=0;i<n;i++){
            lst[i]=sc.nextInt();
        }
        Arrays.sort(lst);
        if(c==2){
            System.out.println(lst[n-1]-lst[0]);
        }
        else{
            int start=1;
            int end=(lst[n-1]-lst[0])/2;
            int ans=0;
            while (start<=end) {
                int mid=(start+end)/2;
                int first=lst[0];
                int cnt=1;
                for(int i=1;i<n;i++){
                    if(lst[i]>=mid+first){
                        first=lst[i];
                        cnt+=1;
                    }
                }
                if(cnt>=c){
                    start=mid+1;
                    ans=mid;
                }
                else{
                    end=mid-1;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}