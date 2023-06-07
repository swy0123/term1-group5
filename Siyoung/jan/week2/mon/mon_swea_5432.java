package com.sy.secweek.mon;

import java.util.Scanner;
/**
 * 문제22: SWEA : 5432 쇠막대기 자르기 ( 제어문 기본 ) 3
 * @author swy05
 */
public class mon_swea_5432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		int len, cnt, sum;
		for(int t=1; t<=T; t++) {
			String str = sc.nextLine();
			str = str.replace("()", "1");
			len = str.length();
			cnt = 0;
			sum = 0;
			for(int i=0; i<len; i++) {
				if(str.charAt(i) == '(') {
					cnt++;
					sum++;
				}
				if(str.charAt(i) == '1') {
					sum+=cnt;
				}
				if(str.charAt(i) == ')'){
					cnt--;
				}
			}
			System.out.println("#"+t+" "+sum);
		}
		
	}

}
