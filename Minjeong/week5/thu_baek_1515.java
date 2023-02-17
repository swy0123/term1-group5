import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int res = 0;
		l: for (int i = 1, k = 0; i <= Integer.MAX_VALUE; i++) {
			char[] chars = Integer.toString(i).toCharArray();
			for (int j = 0; j < chars.length; j++) {
				if (chars[j] == s.charAt(k)) {
					res = i;
					k++;
				}
				if (k == s.length()) break l;
			}
		}
		
		System.out.println(res);
	}
}