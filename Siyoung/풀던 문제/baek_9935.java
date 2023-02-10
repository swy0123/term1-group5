package algorithm.week1.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
/*
 * 문자열 폭발
 */
public class baek_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int blen = bomb.length;
		
		Stack<Character> frt = new Stack<>();
		Stack<Character> byd = new Stack<>();
		
		for(int i=str.length-1; i>=0; i--) {
			byd.add(str[i]);
		}
		
		
		while(!byd.empty()) {
			frt.add(byd.pop());
			if(frt.size()>=blen && frt.peek() == bomb[blen-1]) {
				int cnt = blen-1;
//				System.out.println(frt);
//				System.out.println(byd);
				while(cnt>=0) {
					if(bomb[cnt] == frt.peek()) {
						cnt--;
						frt.pop();
					}
					else {
						for (int i = cnt+1; i < blen; i++) {
							frt.add(bomb[i]);
						}
						break;
					}
				}
				
			}
			
		}
		
		if(frt.empty()) System.out.println("FRULA");
		else {
			for (Character i : frt) {
				System.out.print(i);
			}
		}

	}

}
