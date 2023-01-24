package week1;

import java.util.Scanner;

public class JumpSabang {

	// 동 남 서 북
	static int[] deltaX = { 1, 0, -1, 0 };
	static int[] deltaY = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int N = sc.nextInt();

			int sum = 0;

			int[][] map = new int[X][Y];

			// 입력받음
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 참가자 시작위치 행 열 횟수 int[N][3]
			int[][] player = new int[N][3];

			for (int i = 0; i < player.length; i++) {
				for (int j = 0; j < 3; j++) {
					player[i][j] = sc.nextInt() - 1;
				}
				player[i][2] += 1;
			}

			// 함정
			int boom = sc.nextInt();
			for (int i = 0; i < boom; i++) {
				int boomX = sc.nextInt() ;
				int boomY = sc.nextInt() ;

				map[boomX - 1][boomY - 1] = 0;
			}

			// play

			for (int i = 0; i < player.length; i++) {
				sum -= 1000;

				for (; 0 != player[i][2]; player[i][2]--) {
					//int mapX = player[i][0];
					//int mapY = player[i][1];
					//int temp = map[player[i][0]][player[i][1]];
					//int temp = map[mapX][mapY];
					int dir = map[player[i][0]][player[i][1]] / 10;
					int dis = map[player[i][0]][player[i][1]] % 10;

					player[i][0] = player[i][0] + (deltaY[dir - 1] * dis);
					player[i][1] = player[i][1] + (deltaX[dir - 1] * dis);

					if (!(player[i][0] >= 0 && player[i][0] < X && player[i][1] >= 0 && player[i][1] < Y))
						break;
					if (map[player[i][0]][player[i][1]] == 0)
						break;
				}

				if (player[i][2] == 0) {
					sum += 100 * map[player[i][0]][player[i][1]];
				}
			}
			
			System.out.println("#" + test_case +" " + sum);
		}
	}

}
