package week2;

import java.util.Scanner;

/**
 * BEAK 16926번 배열 돌리기 1
 * 
 * @author elder
 *
 */
public class BEAK_16926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] arr = new int[N][M];
		int temp;
		int prev = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int round = 0; round < Math.min(N, M) / 2; round++) {
			for (int Rotation = 0; Rotation < R; Rotation++) {
				int row = round - 1;
				int col = round;
				prev = arr[row+1][col+1];
				
				int num = 0;
				int direction = 1;
				for (int xxx = 0; xxx < 2; xxx++) {

					for (int i = 0; i < N - round * 2 - num; i++) {
						row += direction;

						temp = arr[row][col];
						arr[row][col] = prev;
						prev = temp;
					}
					
					num++;
					
					for (int i = 0; i < M - round * 2 - num; i++) {
						col += direction;

						temp = arr[row][col];
						arr[row][col] = prev;
						prev = temp;
					}

					direction *= -1;
					
				}
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
