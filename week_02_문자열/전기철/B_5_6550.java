import java.util.Scanner;

public class B_5_6550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1= sc.next();
            String s2= sc.next();
            int cnt=0;
            for(int i=0;i<s2.length();i++){
                if (String.valueOf(s2.charAt(i)).equals(String.valueOf(s1.charAt(cnt)))){
                    cnt+=1;
                }
                if(cnt==s1.length()){
                    break;
                }
            }
            if (cnt==s1.length()){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
        
	sc.close();
	}
    
}
