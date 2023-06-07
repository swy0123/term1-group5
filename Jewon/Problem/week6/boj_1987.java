package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1987 알파벳 골드4
 * 
 * @author elder
 *
 */

public class boj_1987 {

	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R;
	static int C;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = sb.charAt(j);
			}
		}

		sb.append(map[0][0]);
		dfs(0, 0, 1);
		
		System.out.println(ans);

	}

	private static void dfs(int row, int col, int depth) {

		for (int i = 0; i < dir.length; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];
			
			if(nr >= 0  && nr < R && nc >= 0 && nc < C && !sb.toString().contains(map[nr][nc] + "")) {
				sb.append(map[nr][nc]);
				dfs(nr, nc , depth+1); 
				sb.deleteCharAt(sb.length()-1);
			}
		}
		
		ans = Math.max(ans, depth);
	}

}
