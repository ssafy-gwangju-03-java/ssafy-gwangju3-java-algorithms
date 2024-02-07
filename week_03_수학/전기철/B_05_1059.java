import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class B_05_1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		ArrayList<Integer> lst = new ArrayList<>();
		int l = sc.nextInt();
		for (int i=0;i<l;i++){
			int x = sc.nextInt();
			lst.add(x);
		}
		lst.sort(Comparator.naturalOrder());
		int n = sc.nextInt();
		int chk=0;
		int left=0;
		int right=0;
		int ans=0;
		if (lst.get(0)>=n){
			if(n==lst.get(0)){
			chk=1;
			}
			else{
				ans=n*(lst.get(0)-n)-1;
			}
		}
		else{
		for(int i=1;i<l;i++){
			if(n==lst.get(i)){
				chk=1;
				break;
			}
			if (n<lst.get(i)){
				left=lst.get(i-1);
				right=lst.get(i);
				break;
			}
		}
		ans=(n-left)*(right-n)-1;
		}
		if(chk==1){
			System.out.println(0);
		}
		else{
			System.out.println(ans);
		}
		sc.close();
    }

    }