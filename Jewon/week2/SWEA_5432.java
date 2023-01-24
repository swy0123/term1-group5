package week2;

import java.util.Scanner;
import java.util.Stack;

/**
 * SWEA D4
 * 5432. 쇠막대기 자르기
 * @param args
 */


public class SWEA_5432 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			int stack = 0;
			int ans = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack++;
				}else {
					// ')' 입력이면
					if(str.charAt(i-1) == '(') {
						// 레이저당
						stack--;
						ans += stack;
					}else {
						ans++;
						stack--;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		
	}

}
