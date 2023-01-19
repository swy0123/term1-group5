import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	private static String a = "CEFGHIJKLMNSTUVWXYZ";
	private static String c = "ADOPQR";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String res;
			String s1, s2, r1, r2;
			s1 = sc.next();
			s2 = sc.next();
			
			r1 = changeString(s1);
			r2 = changeString(s2);
			
			if (r1.equals(r2)) res = "SAME";
			else res = "DIFF";
			
			System.out.println("#" + testCase + " " + res);
		}

	}
	
	private static String changeString(String s) {
		String res = "";
		
		for (int i = 0; i < s.length(); i++) {
			String tmp = Character.toString(s.charAt(i));
			if (a.contains(tmp)) {
				res += "a";
			} else if (c.contains(tmp)) {
				res += "c";
			} else {
				res += "b";
			}
		}
		return res;
	}

}
