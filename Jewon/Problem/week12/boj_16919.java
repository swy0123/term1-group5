package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_16919 봄버맨 2
 * 
 * @author SSAFY
 *
 */
public class boj_16919 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C, N;
	static int[][] boom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		boom = new int[R][C];
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				if (sb.charAt(j) == '.') {
					boom[i][j] = 0;
				} else {
					boom[i][j] = 2;
				}
			}
		}
		
		int day = 0;
		if(N > 2) {
			day = N % 4 + 4;			
		}else {
			day = N;
		}
		for (int time = 1; time < day; time++) {
			int[][] temp = new int[R][C];
			// 빈곳 설치
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (boom[row][col] == 0) {
						boom[row][col] = 3 + 1;
					}
				}
			}

			// 카운트 및 폭팔
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (boom[row][col] > 1) {
						boom[row][col]--;
					} else if (boom[row][col] == 1) {
						temp[row][col] = -1;
						for (int d = 0; d < dir.length; d++) {
							int nr = row + dir[d][0];
							int nc = col + dir[d][1];
							if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
								temp[nr][nc] = -1;
							}
						}
					}
				}
			}

			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (temp[row][col] == -1) {
						boom[row][col] = 0;
					}
				}
			}

		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (boom[i][j] == 0) {
					sb.append(".");
				} else {
					sb.append("O");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
