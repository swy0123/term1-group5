package IM1;

import java.util.Scanner;

public class JumpSabang {
	
	int [] delta = {};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int N = sc.nextInt();
			
			int[][] map = new int[X][Y];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//참가자 시작위치 행 열 횟수 int[N][3]
			
			
			// 함정
			
			
		}
	}

}
