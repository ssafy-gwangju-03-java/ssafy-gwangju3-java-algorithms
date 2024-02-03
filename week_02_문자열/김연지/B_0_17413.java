package study;

import java.util.Scanner;

public class B_0_17413 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] arr = str.split("");
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int check = 0;
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("<")) {
				check = 1;
				c = 1;
			}else if(arr[i].equals(">")) {
				check = 3;
				c = 0;
			}
			if(check == 1 && arr[i].equals(" ")) {
				check = 4;
			}
			
			else if(arr[i].equals(" ")) {
				check = 2;
			}
			
			if(check == 0) {
				sb.append(arr[i]);
			} else if (check == 1) {
				sb.reverse();
				result.append(sb);
				sb.delete(0, sb.length());
				sb.append(arr[i]);
			}  else if(check == 2 && c==0) {
				sb.reverse();
				result.append(sb);
				result.append(" ");
				sb.delete(0, sb.length());
			} else if(check == 2 && c ==1) {
				result.append(sb);
				result.append(" ");
				sb.delete(0, sb.length());
			} else if(check == 3) {
				sb.append(arr[i]);
				result.append(sb);
				sb.delete(0, sb.length());
			} 
			check = 0;
						}
		if(sb.length()!=0) {
			sb.reverse();
			result.append(sb);
		}
		
		System.out.println(result);
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		}



