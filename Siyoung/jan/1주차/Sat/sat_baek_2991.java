package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 문제14: 백준 : 사나운개
 * @author swy05
 */
public class sat_baek_2991 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		//개1 a분 공격, b분 휴식
		//개2 c분 공격, d분 휴식
		//p우체부 도착, m우유배달 도착, n신문 도착
		
		int a, b, c, d, p, m, n;
		int retp = 0, retm = 0, retn = 0;
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		p = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
	
		
		if(dogAtk(a, b, p)) retp++;
		if(dogAtk(c, d, p)) retp++;
		if(dogAtk(a, b, m)) retm++;
		if(dogAtk(c, d, m)) retm++;
		if(dogAtk(a, b, n)) retn++;
		if(dogAtk(c, d, n)) retn++;
		
		System.out.println(retp);
		System.out.println(retm);
		System.out.println(retn);

	}
	static boolean dogAtk(int a, int b, int target) {
		int cur = target / (a+b);
		if(cur*(a+b) < target && cur*(a+b)+a >= target) {
			return true;
		}
		else return false;
	}

}
