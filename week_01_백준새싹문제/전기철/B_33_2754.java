import java.util.Scanner;

public class B_33_2754 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s = sc.nextLine();
	double a=0;
	char x = s.charAt(0);
	char y = s.charAt(1);
	if(x=='A'){
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
		a+=0.0;
	}
	System.out.println(a);
	sc.close();
}
}
