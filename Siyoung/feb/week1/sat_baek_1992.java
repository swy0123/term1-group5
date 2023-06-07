package com.ssafy.feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 1992 쿼드트리
 */
public class sat_baek_1992 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		String str;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		for (int[] i : map) {
//			System.out.println(Arrays.toString(i));
//		}
		
		func(0, 0, n);
	}
	
	
	private static void func(int i, int j, int size) {
		if(check(i, j, size)) {
			System.out.print(map[i][j]);
			return;
		}
		else {
			System.out.print("(");
			
			func(i, j, size/2);
			func(i, j+size/2, size/2);
			func(i+size/2, j, size/2);
			func(i+size/2, j+size/2, size/2);
			
			System.out.print(")");
		}
		
	}
	
	//주어진 범위가 같은지 확인
	private static boolean check(int i, int j, int size) {
		for(int ci=i; ci<i+size; ci++) {
			for(int cj=j; cj<j+size; cj++) {
				if(map[i][j] != map[ci][cj]) {
					return false;
				}
			}
		}
		return true;
	}

}
