package ssafy.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String original;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			original = br.readLine();
			StringBuilder sb = new StringBuilder();
			flag = false;
			for (int i = 0; i < original.length(); i++) sb.append("0");
			
			System.out.println("#" + testCase + " " + find(0, sb.toString(), 0));
		}

	}
	
	private static int find(int pos, String cur, int cnt) {
		if (original.equals(cur)) {
			return cnt;
		}
		if (pos == cur.length()) return 987654;

		char c;
		if (cur.charAt(pos) == '0') c = '1';
		else c = '0';
		StringBuilder sb = new StringBuilder();
		sb.append(cur.substring(0, pos));
		for (int i = pos; i < cur.length(); i++) sb.append(c);
		return Math.min(find(pos + 1, cur, cnt), find(pos + 1, sb.toString(), cnt + 1));
	}

}
