package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_2630 색종이 만들기 실버2
 * 
 * @author SSAFY
 *
 */
public class boj_2630 {

	static int N;
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cut(int row, int col, int size) {
		int sum = 0;

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == size * size) {
			blue++;
		} else if (sum == 0) {
			white++;
		} else {
			int half = size / 2;
			cut(row, col, half);
			cut(row, col + half, half);
			cut(row + half, col, half);
			cut(row + half, col + half, half);
		}

	}

}
