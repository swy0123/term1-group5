package IM;

import java.util.Scanner;

public class RobotMove {
	// 상 하 좌 우
	static int[] deltar = { -1, 1, 0, 0 };
	static int[] deltac = { 0, 0, -1, 1 };
	static char[] robot = { 'A', 'B', 'C' };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			int robotN = 0;
			int[] robotR = new int[100];
			int[] robotC = new int[100];

			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next().charAt(0);

					if (arr[i][j] == 'A' | arr[i][j] == 'B' | arr[i][j] == 'C') {
						robotR[robotN] = i;
						robotC[robotN] = j;
						robotN++;
					}
				}
			}

			for (; robotN != 0; robotN--) {
				sum += howS(arr, arr[robotR[robotN - 1]][robotC[robotN - 1]], robotR[robotN - 1], robotC[robotN - 1]);
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}

	private static int howS(char[][] arr, char c, int i, int j) {
		// TODO Auto-generated method stub
		int sum = 0;
		int temp = 0;
		switch (c) {

		case 'C':

			// up
			temp = 1;
			while(i - temp >= 0 && arr[i - temp][j] == 'S') {
				temp++;
			}

			sum += (temp - 1);

			// down
			temp = 1;
			while(i + temp < arr.length && arr[i + temp][j] == 'S') {
				temp++;
			}
			

			sum += (temp - 1);

		case 'B':

			// 좌측 + A
			temp = 1;
			while(j - temp >= 0 && arr[i][j - temp] == 'S') {
				temp++;
			}
			

			sum += (temp - 1);

		case 'A':
			// 우측
			temp = 1;

			while(j + temp < arr.length && arr[i][j + temp] == 'S') {
				temp++;
			}
			

			sum += (temp - 1);

		}
		
		return sum;
	}

}
