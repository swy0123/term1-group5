package com.sy.firstweek.sun;

import java.util.Scanner;
/**
 * 문제20: SWEA : 1940 가랏! RC카 ( 제어문 입문 ) 1
 * @author swy05
 */
public class sun_swea_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n, curSpeed, cmd, ac, len;
		
		for(int t=1; t<=T; t++) {
			n =sc.nextInt();
			curSpeed = 0;
			len = 0;
			ac = 0;
			for(int i=0; i<n; i++) {
				cmd = sc.nextInt();
				
				switch (cmd) {
				case 0:
					len += curSpeed;
					break;
				case 1:
					ac = sc.nextInt();
					curSpeed += ac;
					len += curSpeed;
					break;
				case 2:
					ac = sc.nextInt();
					curSpeed -= ac;
					if(curSpeed <= 0) curSpeed = 0;
					len += curSpeed;
					break;
				default:
					break;
				}
			}
			
			System.out.println("#"+t+" "+ len);
		}
	}
}
