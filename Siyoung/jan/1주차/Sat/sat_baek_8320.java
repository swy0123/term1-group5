package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 문제8 : 백준 :  8320 직사각형을 만드는 방법
 * @author swy05
 */
public class sat_baek_8320 {
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        for(int i=1; i<=n; i++) {
        	for(int j=i; j<=n; j++) {
        		if(i*j<=n) res++;
        		else break;
        	}
        }
    	
        System.out.println(res);
    }
}
