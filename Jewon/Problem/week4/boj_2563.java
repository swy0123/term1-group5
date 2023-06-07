package week4;

import java.util.Scanner;

/**
 * 
 * boj_2563 색종이 실버5
 * 
 * @author elder
 *
 */
public class boj_2563 {
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new int[100][100];
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			fill(x, y);
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void fill(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				if(i < 100 && y<100) {
					map[i][j] = 1;
				}
			}
		}
	}

}
