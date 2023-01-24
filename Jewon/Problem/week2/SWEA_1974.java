package week2;

import java.util.Scanner;

public class SWEA_1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr;
		for (int test_case = 1; test_case <= T; test_case++) {
			arr = new int[9][9];
			int check = 1;
			int count = 0;

			// init arr
			for (int i = 0; i < 9; i++) {
				for (int ii = 0; ii < 9; ii++) {
					arr[i][ii] = sc.nextInt();
				}
			}

			// check 1
			for (int i = 0; i < 9; i++) {

				int sum = 0;

				for (int ii = 0; ii < 9; ii++) {
					sum += arr[i][ii];
				}

				if (sum != 45) {
					check = 0;
				}
			}

			// check 2
			for (int i = 0; i < 9; i++) {

				int sum = 0;

				for (int ii = 0; ii < 9; ii++) {
					sum += arr[ii][i];
				}

				if (sum != 45) {
					check = 0;
				}
			}

			// check 3
			for (int i = 0; i < 3; i++) {
				for (int ii = 0; ii < 3; ii++) {

					int sum = 0;

					for (int row = i * 3; row < i * 3 + 3; row++) {
						for (int col = ii * 3; col < ii * 3 + 3; col++) {
							sum += arr[row][col];
						}
					}

					if (sum != 45) {
						check = 0;
					}
				}
			}

			System.out.println("#" + test_case + " " + check);

		}

	}

}
