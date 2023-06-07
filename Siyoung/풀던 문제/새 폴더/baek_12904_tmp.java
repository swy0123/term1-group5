package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baek_12904_tmp {
	static boolean ret;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();

		int n = s.length();
		sb = new StringBuilder(s);
		check(sb, t, false, n);
		
		if(ret) System.out.println(1);
		else System.out.println(0);
	
	}
	
	private static void check(StringBuilder cur, String t, boolean reverse, int n) {
		if(n == t.length()) {
			if(reverse) {
				sb = new StringBuilder();
				for(int i=cur.length()-1; i>=0; i--) {
					sb.append(cur.charAt(i));
				}
				cur = sb;
			}

			if(cur.toString().equals(t)) ret = true;
			
			return;
		}
		
		if(reverse) {
			sb = new StringBuilder("A");
			sb.append(cur);
			check(sb, t, reverse, n+1);
			sb = new StringBuilder("cur");
			sb.append("B");
			check(sb, t, !reverse, n+1);
		}
		else {
			sb = new StringBuilder(cur);
			sb.append("A");
			check(sb, t, reverse, n+1);
			sb = new StringBuilder("B");
			sb.append(cur);
			check(sb, t, !reverse, n+1);
		}
	}
	
	
}
