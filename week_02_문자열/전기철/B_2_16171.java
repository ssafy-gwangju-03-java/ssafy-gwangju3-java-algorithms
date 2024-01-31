import java.util.Scanner;

public class B_2_16171 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)>=48 && s1.charAt(i)<58){
				s1=s1.replace(String.valueOf(s1.charAt(i))," ");
			}
		}
		s1=s1.replace(" ","");
		if(s1.contains(s2)){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
	sc.close();
	}
}
