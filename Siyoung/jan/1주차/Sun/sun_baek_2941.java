package com.sy.firstweek.sun;

import java.util.Scanner;
/**
 * 문제16: 백준 : 2941 : 크로아티아 알파벳
 * @author swy05
 */
public class sun_baek_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String[] dic = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String str = sc.nextLine();
		
		for(String i:dic) {
			str = str.replace(i, "A");
		}
		System.out.println(str.length());
		

	}

}
