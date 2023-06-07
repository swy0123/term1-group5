package assign;

import java.util.Scanner;
import java.util.Stack;
/**
 * [1월 30일] 1218. 괄호 짝짓기 D4
 * @author SSAFY
 */
public class fri_swea_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		boolean ret;
		for(int t=1; t<=10; t++) {
			n = sc.nextInt();
			sc.nextLine();
			
			Stack<Character> s1 = new Stack();
			String str = sc.nextLine();
			char x = 0;
			ret = true;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case '(':
					s1.push(c);
					break;
				case ')':
					if(s1.empty()) ret = false;
					else if((x = s1.pop()) != '(') ret = false;
					break;
				case '[':
					s1.push(c);
					break;
				case ']':
					if(s1.empty()) ret = false;
					else if((x = s1.pop()) != '[') ret = false;
					break;
				case '{':
					s1.push(c);
					break;
				case '}':
					if(s1.empty()) ret = false;
					else if((x = s1.pop()) != '{') ret = false;
					break;
				case '<':
					s1.push(c);
					break;
				case '>':
					if(s1.empty()) ret = false;
					else if((x = s1.pop()) != '<') ret = false;
					break;
				default:
					break;
				}
				if(!ret) {
					break;
				}
			}
			if(!s1.empty()) ret = false;

			if(ret) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}
		
	}

}
