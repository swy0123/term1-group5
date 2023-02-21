package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 문제9 : 정올 : 1523 별삼각형1
 * @author swy05
 */
public class sat_jung_1523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n>100 || n<0 || m<1 || m>3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch (m) {
		case 1: {
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		}
		case 2: {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n-i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		}
		case 3: {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n-i-1; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<i*2+1; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		}
		default:
			break;
		}

	}

}
