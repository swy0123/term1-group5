package IM1;

import java.util.Scanner;

//소금쟁이
//날라다니는 스파게티...

public class Saltman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int SaltN = sc.nextInt();
			int i = 0;
			// 0으로 초기화
			int[][] arr = new int[N][N];

			int[] Saltrow = new int[SaltN];
			int[] Saltcol = new int[SaltN];
			int[] Saltdir = new int[SaltN];

			for (i = 0; i < SaltN; i++) {
				Saltrow[i] = sc.nextInt();
				Saltcol[i] = sc.nextInt();
				Saltdir[i] = sc.nextInt();
			}

			for (i = 0; i < 3; i++) {
				for (int j = 0; j < SaltN; j++) {
					// 2번 뛰어 나갈때
					if (jump(arr, Saltrow, Saltcol, Saltrow[j], Saltcol[j], Saltdir[j], i , j)) {
						System.out.println("#" + test_case + " " + (j + 1));
						
						// 어? 다음 테스트 케이스로 가고 싶은데?
						i = 100;
						j = SaltN + 1; 
					}
				}
			}
			
			if(i != 101) {
				System.out.println("#" + test_case + " " + (0));				
			}
		}
	}

	private static boolean jump(int[][] arr, int[] saltrow, int[] saltcol, int i, int j, int k, int i2 , int j2) {
		// TODO Auto-generated method stub
		int distance = 3 - i2;
		
		//연못 밖인가?
		if(i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
			// 점프 ~
			arr[i][j]++; 
			
			// 두번 뛰었나?
			if (arr[i][j] >= 2) {
				return true;
			}
			
			// 1 하 2 우
			if (k == 1) {
				saltrow[j2] += distance;
			} else if (k == 2) {
				saltcol[j2] += distance;
			}
			
		}

		return false;
	}

}
