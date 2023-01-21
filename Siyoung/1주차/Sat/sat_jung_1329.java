package com.sy.firstweek.sat;

import java.util.Scanner;

/**
 * 정올 1329 : 별삼각형3
 * @author swy05
 */
public class sat_jung_1329 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n<0 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int c = n/2;
		
		for(int i=0; i<=c; i++) {
			for(int j=0; j<i; j++) {
				System.out.printf(" ");
			}
			for(int j=0; j<=i*2; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i=c-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				System.out.printf(" ");
			}
			for(int j=0; j<=i*2; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

	}

}
