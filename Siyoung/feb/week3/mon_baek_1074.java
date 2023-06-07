package algorithm.week3;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 백준 1074 Z
 */
public class mon_baek_1074 {

	static int r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int num = (int) Math.pow(2, n);
		int cnt = 0;
		count(0, 0, n, cnt);
	}
	
	private static void count(int i, int j, int n, int cnt) {
		if(n == 0) {
			if(i==r && j==c) System.out.println(cnt);
			return;
		}
		
			
		int num = (int) Math.pow(2, n);
		
		if(r >= i && r < i+num/2) {
			if(c >= j && c < j+num/2) count(i, j, n-1, cnt + (int) Math.pow(4, n-1)*0);
			else count(i, j+num/2, n-1, cnt + (int) Math.pow(4, n-1)*1);
		}
		else{
			if(c >= j && c < j+num/2) count(i+num/2, j, n-1, cnt + (int) Math.pow(4, n-1)*2);
			else count(i+num/2, j+num/2, n-1, cnt + (int) Math.pow(4, n-1)*3);
		}
		
	}
}
