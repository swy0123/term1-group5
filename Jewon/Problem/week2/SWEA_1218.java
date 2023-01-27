package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기 D4
 * 
 * @author elder
 *
 */
public class SWEA_1218 {
	static String open = "([{<";
	static String close = ")]}>";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int length = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			outer: for (char c : br.readLine().toCharArray()) {
				if (open.contains(c + "")) {
					sb.append(c);
				} else {
					for (int i = 0; i < 4; i++) {
						if (c == close.charAt(i)) {
							if (sb.charAt(sb.length() - 1) == open.charAt(i)) {
								sb.deleteCharAt(sb.length() - 1);
							} else {
								// 0 출력
								System.out.println("#" + test_case + " " + 0);
								break outer;
							}
						}
					}
				}
			}

			if (sb.length() == 0) {
				System.out.println("#" + test_case + " " + 1);
			}

		}

	}

}
