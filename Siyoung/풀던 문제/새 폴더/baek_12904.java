package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_12904 {
	static boolean ret;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sn = 0;
		int tn = 0;
		String s = br.readLine();
		String t = br.readLine();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'A') sn << 1;
			else sb.append(1);
		}
		s = sb.toString();
		sb = new StringBuilder();
		for(int i=0; i<t.length(); i++) {
			if(t.charAt(i) == 'A') sb.append(0);
			else sb.append(1);
		}
		t = sb.toString();
		
//		check(s,t);
		
		if(ret) System.out.println(1);
		else System.out.println(0);
	
	}
	
	private static void check(int cur, int t) {
		if(cur >= t) {
			if(cur == t) ret = true;
			return;
		}
		
		
		
		check(cur+"A", t);
		

		
		for(int i=cur.length()-1; i>=0; i--) {
			sb.append(cur.charAt(i));
		}
		check(sb.toString()+"B", t);
		
		
	}
	
	
}
