package week2;

import java.util.Scanner;

public class SWEA_2805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			int[][] map = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			
			
			for (int i = 0; i < map.length; i++) {
				int temp = Math.abs(N / 2 - i);
				for (int j = temp; j < N  - temp; j++) {
					sum += map[i][j];
					
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}

}
