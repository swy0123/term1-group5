package algorithm.week1.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 백준 9012 괄호 (스택)
 */
public class fri_baek_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		char[] carr = new char[n];
		
		for(int i=0; i<n; i++) {
			carr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for(int j=0; j<carr.length; j++) {
				if(carr[j] == '(') {
					stack.add('(');
				}
				if(carr[j] == ')') {
					if(stack.empty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			if(stack.empty() && flag) System.out.println("YES");
			else System.out.println("NO");
			
		}

	}

}
