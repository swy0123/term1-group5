package feb.week2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
 * 백준 2447 별찍기10
 */
public class tue_baek_2447 {

	static String[] start = {"***", "* *", "***"};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (String string : star(start, n)) {
			System.out.println(string);
		}

	}
	
	private static String[] star(String[] s, int cnt) {
		if(cnt==3) return s;
		
		StringBuilder sb = new StringBuilder();
		
		for (String str : s) {
			sb.append(str);
			sb.append(str);
			sb.append(str);
			sb.append("\n");
		}
		
		for (String str : s) {
			sb.append(str);
			for(int i=0; i<str.length(); i++) {
				sb.append(" ");
			}
			sb.append(str);
			sb.append("\n");
		}
		
		for (String str : s) {
			sb.append(str);
			sb.append(str);
			sb.append(str);
			sb.append("\n");
		}
		
		return star(sb.toString().split("\n"), cnt/3);
	}
	

}
