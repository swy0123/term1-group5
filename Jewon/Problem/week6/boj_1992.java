package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_1992 쿼드트리 실버1
 * 
 * @author SSAFY
 *
 */
public class boj_1992 {
	static int[][] arr;
	static int N;
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = sb.charAt(j) - '0';
			}
		}
		//

		cut(0, 0, N);
		
		System.out.println(ans);
	}

	private static void cut(int row, int col, int size) {
		int sum = 0;

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				sum += arr[i][j];
			}
		}
		
		if (sum == size * size) {
			ans.append(1);
		} else if (sum == 0) {
			ans.append(0);
		} else {
			ans.append('(');
			int half = size / 2;
			cut(row, col, half);
			cut(row, col + half, half);
			cut(row + half, col, half);
			cut(row + half, col + half, half);
			ans.append(')');
		}
		
	}

}
