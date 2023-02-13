package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
/*
 * 백준 9935 문자열 폭발
 */
public class mon_baek_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int blen = bomb.length;
		
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length; i++) {
			s.add(str[i]);
			if(s.size()>=blen && s.peek() == bomb[blen-1]) {
				Stack<Character> tmp = new Stack<>();
				for(int j=blen-1; j>=0; j--) {
					if(s.empty() || s.peek() != bomb[j]) {
						while(!tmp.empty()) {
							s.add(tmp.pop());
						}
						break;
					}
					tmp.add(s.pop());
				}
			}
		}
		
		if(s.empty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for (Character c : s) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		


	}

}
