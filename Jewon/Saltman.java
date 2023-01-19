package IM;

import java.util.Scanner;

//소금쟁이
public class Saltman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int SaltN = sc.nextInt();

			// 0으로 초기화
			int[][] arr = new int[N][N];

			int[] Saltrow = new int[SaltN];
			int[] Saltcol = new int[SaltN];
			int[] Saltdir = new int[SaltN];

			for (int i = 0; i < SaltN; i++) {
				Saltrow[i] = sc.nextInt();
				Saltcol[i] = sc.nextInt();
				Saltdir[i] = sc.nextInt();
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < SaltN; j++) {
					// 2번 뛰어 나갈때
					if(jump(arr, Saltrow[i], Saltcol[i], Saltdir[i])) {
						
					}
				}
			}
		}
	}

	private static boolean jump(int[][] arr, int i, int j, int k) {
		// TODO Auto-generated method stub
		// 체크후 점프
	}

}
