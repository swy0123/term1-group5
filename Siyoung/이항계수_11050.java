package test;

import java.util.Scanner;

public class 이항계수_11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(sol(n, m));
	}
	
	private static int sol(int n, int m) {
		if(n==1 || n==0) return 1;
		if(m==0 || m==n) return 1;
		return sol(n-1, m-1)+sol(n-1, m);
	}
}
