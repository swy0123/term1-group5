package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스도쿠 boj_2580 골드4
 * 
 * @author SSAFY
 *
 */

public class boj_2580 {
	static int[][] arr;
	static int max_depth = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					max_depth++;
				}
			}
		}

		back_tracking(0);

	}

	private static void back_tracking(int depth) {
		// TODO Auto-generated method stub
		if (depth == max_depth) {
			print();
			System.exit(0);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					for (int num = 1; num <= arr.length; num++) {
						// 하나 씩 넣어보며 체크
						if (check(i, j , num)) {
							arr[i][j] = num;
							back_tracking(depth + 1);
							arr[i][j] = 0;
						}
					}
					return;
				}
			}
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


	private static boolean check(int row, int col ,int num) {

		// 가로
		for (int i = 0; i < 9; i++) {
			if (num == arr[row][i] && i != col) {
				return false;
			}
		}

		// 세로 췤
		for (int i = 0; i < 9; i++) {
			if (num == arr[i][col] && i != row) {
				return false;
			}
		}

		// 해당칸 췤

		int r = row / 3 * 3;
		int c = col / 3 * 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (num == arr[i][j] && i != row && j != col) {
					return false;
				}
			}
		}

		//
		return true;
	}

}
