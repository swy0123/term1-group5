package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 정올 1719 : 별삼각형2
 * @author swy05
 */
public class sat_jung_1719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n>100 || n<1 || n%2==0 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int c = n/2;
		switch (m) {
		case 1:
			for(int i=0; i<=c; i++) {
				for(int j=0; j<=i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			for(int i=c; i>0; i--) {
				for(int j=0; j<i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i=0; i<=c; i++) {
				for(int j=0; j<c-i; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<=i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			for(int i=0; i<c; i++) {
				for(int j=0; j<=i; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<c-i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for(int i=0; i<=c; i++) {
				for(int j=0; j<i; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<=(c-i)*2; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			for(int i=0; i<c; i++) {
				for(int j=0; j<c-i-1; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<=(i+1)*2; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		case 4:
			for(int i=0; i<=c; i++) {
				for(int j=0; j<i; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<=c-i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			for(int i=0; i<c; i++) {
				for(int j=0; j<c; j++) {
					System.out.printf(" ");
				}
				for(int j=0; j<=(i+1); j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		default:
			break;
		}
	}
}
