package test;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class 아파트_칠하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] b = new int[n+1];
		b[1] = 1;
		int[] y = new int[n+1];
		y[1] = 1;
		
		for(int i=2; i<=n; i++) {
			b[i] = y[i-1];
			y[i] = b[i-1]+y[i-1];
		}
		System.out.println(b[n]+y[n]);
	}

}
