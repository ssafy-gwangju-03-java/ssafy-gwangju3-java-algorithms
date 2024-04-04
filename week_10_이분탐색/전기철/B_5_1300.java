import java.util.Scanner;

public class B_5_1300 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int start=1;
        int end=k;
        int ans=0;
        while(start<=end){
            int cnt=0;
            int mid=(start+end)/2;
            for(int i=1;i<n+1;i++){ // i열 -> i*j 
                cnt+=Math.min(mid/i,n); // i열에서 mid보다 작은 값 개수 -> mid/i 개인데 최대 개수인 n을 넘어갈 수 있으므로 Math.min
            }
            if(cnt>=k){
                end=mid-1;
                ans=mid;
            }
            else{
                start=mid+1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
