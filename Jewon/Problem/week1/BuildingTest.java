package week1;

import java.util.Scanner;

/**
 * B구획의 빌딩 최고 높이 구하기
 * 
 * testcase
 * 	3
	6
	G B G G B B
	G B G G B G
	B B B B G B
	B G B B B B
	G B B B B G
	G B B B B G
	5
	G B G G B
	G B G G B
	B B B B G
	B G B B B
	G B B B B
	3
	G G B
	G B B
	B B B
 */
public class BuildingTest {

	public static void main(String[] args) throws Exception {
		// 코드를 작성해주세요.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 배열의 크기

			int max = 0;
			char[][] arr = new char[N][N];

			// 값 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}

			//
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'B') {
						if (check(arr, i, j)) {
							// 주변에 공원이 없다.
							int temp = howB(arr, i, j);
							max = Math.max(max, temp);
						} else {
							// 주변에 공원이 있다
							int temp = 2;
							max = Math.max(max, temp);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	private static int howB(char[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;

		for (int k = 0; k < arr.length; k++) {
			if (arr[i][k] == 'B') {
				count++;
			}

			if (arr[k][j] == 'B') {
				count++;
			}
		}

		return count - 1;
	}

	private static boolean check(char[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		for (int j2 = -1; j2 <= 1; j2++) {
			for (int k = -1; k <= 1; k++) {
				int x = i + j2;
				int y = j + k;

				if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
					if (arr[x][y] == 'G') {
						return false;
					}
				}
			}
		}

		return true;
	}

}