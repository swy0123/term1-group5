package com.sy.firstweek.sun;

import java.util.Scanner;
/**
 * 문제17: 백준 : 2999 : 비밀 이메일
 * @author swy05
 */
public class sun_baek_2999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int len = str.length();
		int r=0, c=0;
		
		for(int i=1; i<=len; i++) {
			if(len/i<i) break;
			if((len/i)*i == len && i>=r) {
				r = i;
				c = len/i;
			}
		}
//		System.out.println(r + " " + c);
		
		char[][] arr = new char[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[i][j] = '0';
			}
		}
		int idx = 0;

		for(int j=0; j<c; j++) {
			for(int i=0; i<r; i++) {
				arr[i][j] = str.charAt(idx);
				idx++;
			}
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j] != '0') {
					System.out.printf("%c", arr[i][j]);
				}
				else break;
				
			}
		}

	}

}
