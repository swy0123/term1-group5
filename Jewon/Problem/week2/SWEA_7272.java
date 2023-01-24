package week2;

import java.util.Scanner;

//안경이 없어!
public class SWEA_7272 {

	static String[] strs = { "CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str1 = sc.next();
			String str2 = sc.next();
			String ans = "SAME";

			if (str1.length() == str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					for (int j = 0; j < 3; j++) {
						if ((strs[j].contains(str1.charAt(i) + "") ^ strs[j].contains(str2.charAt(i) + ""))) {
							ans = "DIFF";
						}
					}
				}
			} else {
				ans = "DIFF";
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}

}
