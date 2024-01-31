import java.util.Scanner;

public class B_4_4659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.nextLine();
			int acnt=0;//모음 수
			int anow=0;//모음 연속개수
			int bnow=0;//자음 연속개수
			int cnt=0;//스위치
			String chk = new String(); //전에꺼 저장
			if (s.equals("end")){
				break;
			}
			for(int i=0;i<s.length();i++){
				String s1=String.valueOf(s.charAt(i));
				if(i==0){
					if(s1.equals("a") || s1.equals("e")||s1.equals("i")|| s1.equals("o")||s1.equals("u")){
						acnt+=1;
						anow+=1;
						bnow=0;
						chk=s1;
					}
					else{//자음입력
						anow=0;
						bnow+=1;
						chk=s1;
					}
				}
				else{
					if(s1.equals(chk)){//3번조건
						if(chk.equals("e")||chk.equals("o") &&anow==1){
							anow+=1;
						}
						else{
							cnt=1;
							break;
						}
						if (anow==3 || bnow==3){//2번조건
							cnt=1;
							break;
						}
					}
					else{
						if(s1.equals("a") || s1.equals("e")||s1.equals("i")|| s1.equals("o")||s1.equals("u")){
							acnt+=1;
							anow+=1;
							bnow=0;
							chk=s1;
						}
						else{//자음입력
							anow=0;
							bnow+=1;
							chk=s1;
						}
						if (anow==3 || bnow==3){//2번조건
							cnt=1;
							break;
						}
					}
				}
			}
			if(cnt==1 || acnt==0){//1번조건
				System.out.println("<"+s+"> is not acceptable.");
			}
			else{
				System.out.println("<"+s+"> is acceptable.");
			}
		}
		sc.close();
	}
}
