package week1;

import java.util.Scanner;



public class MazeArrivalPoint {

	// 북 동 남 서
	static int[][] delta = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 배열크기
			int X = sc.nextInt() - 1; // 시작지점
			int Y = sc.nextInt() - 1; // 시작지점
			int jumperN = sc.nextInt(); // 점퍼 개수
			
			// 점퍼 좌표
			int[][] jumps = new int[jumperN][2];
			for (int i = 0; i < jumperN; i++) {
				jumps[i][0] = sc.nextInt() - 1;
				jumps[i][1] = sc.nextInt() - 1;
			}

			// 이동 지시 개수
			int moveN = sc.nextInt();
			for (int i = 0; i < moveN; i++) {
				int dir = sc.nextInt() - 1;
				int dis = sc.nextInt();

				if (!(X == -1 && Y == -1)) {
					// 이동
					X += delta[0][dir] * dis;
					Y += delta[1][dir] * dis;

					// 검사

					// 넘어감?
					if (!(X >= 0 && X < N - 1 && Y >= 0 && Y < N - 1)) {
						X = -1;
						Y = -1;
					}

					// 점퍼
					for (int j = 0; j < jumps.length; j++) {
						if (jumps[j][0] == X && jumps[j][1] == Y) {
							X = -1;
							Y = -1;
							break;
						}
					}
				}

			}

			System.out.println("#" + test_case + " " + (X + 1) + " " + (Y + 1));
		}
	}

}
