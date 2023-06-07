package week2;

import java.util.Iterator;
import java.util.Scanner;

// SWEA 1234. [S/W 문제해결 기본] 10일차 - 비밀번호

public class SWEA_1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String str = sc.next();
			int i = 0;

			while (i != str.length() - 1) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					if (i + 2 < N) {
						str = str.substring(0, i) + str.substring(i + 2);
					} else {
						str = str.substring(0, i);
					}
					
					if(i != 0) i--;
					continue;
				}
				
				i++;
			}
			
			System.out.println("#" + test_case + " " + str);
		}
	}

}
