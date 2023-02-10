package week4;

import java.util.Scanner;

public class boj_16927 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int round = 0; round < Math.min(M, N) / 2; round++) {
			int size = 2 * (M - 2 * round) + 2 * (N - 2 * round) - 4;
			int[] list = new int[size];
			int x = round;
			int y = round;
			int temp = arr[x][y];
			int cnt = 0;

			// 일자로 핀 배열 만들기
			for (int i = 0; i < M - (2 * round) - 1; i++) {
				list[cnt] = arr[x][y];
				y++;
				cnt++;
			}

			for (int i = 0; i < N - (2 * round) - 1; i++) {
				list[cnt] = arr[x][y];
				x++;
				cnt++;
			}

			for (int i = 0; i < M - (2 * round) - 1; i++) {
				list[cnt] = arr[x][y];
				y--;
				cnt++;
			}

			for (int i = 0; i < N - (2 * round) - 1; i++) {
				list[cnt] = arr[x][y];
				x--;
				cnt++;
			}
			
			// 회전한 값 세팅
			cnt = R;
			cnt %= size;
			
			// 배열 고치기
			for (int i = 0; i < M - (2 * round) - 1; i++) {
				arr[x][y] = list[cnt];
				y++;
				cnt++;
				cnt %= size;
			}

			for (int i = 0; i < N - (2 * round) - 1; i++) {
				arr[x][y] = list[cnt];
				x++;
				cnt++;
				cnt %= size;
			}

			for (int i = 0; i < M - (2 * round) - 1; i++) {
				arr[x][y] = list[cnt];
				y--;
				cnt++;
				cnt %= size;
			}

			for (int i = 0; i < N - (2 * round) - 1; i++) {
				arr[x][y] = list[cnt];
				x--;
				cnt++;
				cnt %= size;
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
