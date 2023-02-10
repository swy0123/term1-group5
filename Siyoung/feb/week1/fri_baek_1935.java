package algorithm.week1.fri;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/*
 * 백준 1935 후위표기식
 */
public class fri_baek_1935 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		char[] ch = sc.nextLine().toCharArray();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Double> st = new Stack<>();
		double num1, num2;
		for(int i=0; i<ch.length; i++) {
			if(ch[i] >= 'A' && ch[i] <= 'Z') {
				st.add((double)arr[ch[i]-'A']); 
			}
			else {
				num2 = st.pop();
				num1 = st.pop();
				st.add(cal(num1, num2, ch[i]));
			}
		}
		System.out.printf("%.2f\n", st.peek());

	}
	
	private static double cal(double num1, double num2, char chr) {
		
		switch (chr) {
		case '+':
			return num1+num2;
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/num2;

		default:
			break;
		}
		
		return num2;
		
	}

}
