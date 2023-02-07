package com.ssafy.feb.week1;

import java.util.Scanner;
/*
 * 난이도 하 13300번 - 방 배정
 */
public class tue_baek_13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int res = 0;
		int gender, grade;
		int[][] arr = new int[7][2];
		
		for(int i=0; i<n; i++) {
			gender = sc.nextInt();
			grade = sc.nextInt();
			arr[grade][gender]++;
		}
		
		for(int i=1; i<7; i++) {
			for(int j=0; j<2; j++) {
				if(arr[i][j] % k == 0) res += arr[i][j]/k;
				else res += (arr[i][j]/k)+1;
			}
		}
		System.out.println(res);

	}

}
