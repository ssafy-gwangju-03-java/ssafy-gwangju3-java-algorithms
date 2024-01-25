import java.util.Scanner;

public class B_33_2754 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s = sc.nextLine();
	double a=0;
	char x = s.charAt(0);
	if(x=='A'){
		char y = s.charAt(1);
		a+=4.0;
		if(y=='+'){
			a+=0.3;
		}
		else if(y=='-'){
			a-=0.3;
		}
		else{
			a+=0;
		}
	}
	else if(x=='B'){
		char y = s.charAt(1);
		a+=3.0;
		if(y=='+'){
			a+=0.3;
		}
		else if(y=='-'){
			a-=0.3;
		}
		else{
			a+=0;
		}
	}
	else if(x=='C'){
		char y = s.charAt(1);
		a+=2.0;
		if(y=='+'){
			a+=0.3;
		}
		else if(y=='-'){
			a-=0.3;
		}
		else{
			a+=0;
		}
	}
	else if(x=='D'){
		char y = s.charAt(1);
		a+=1.0;
		if(y=='+'){
			a+=0.3;
		}
		else if(y=='-'){
			a-=0.3;
		}
		else{
			a+=0;
		}
	}
	else{
		a+=0;
	}
	System.out.println(a);
	sc.close();
}
}
