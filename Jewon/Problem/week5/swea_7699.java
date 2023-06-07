package pkg02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * swea_7699 수지의 수지 맞는 여행 D4
 * 
 * @author SSAFY
 *
 */

public class swea_7699 {
	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R;
	static int C;
	static char[][] map;
	static StringBuilder checkList;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			checkList = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				sb = new StringBuilder(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = sb.charAt(j);
				}
			}
			
			checkList.append(map[0][0]);
			dfs(0, 0, 1);
			
			System.out.println("#"+ test_case + " " + ans);
		}
	}

	private static void dfs(int i, int j , int depth) {
		// TODO Auto-generated method stub

		for (int d = 0; d < dir.length; d++) {
			int nr = i + dir[d][0];
			int nc = j + dir[d][1];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !checkList.toString().contains(map[nr][nc] +"")) {
				checkList.append(map[nr][nc]);
				dfs(nr,nc, depth+1);
				checkList.deleteCharAt(checkList.length()-1);
			}
		}
		
		ans = Math.max(ans, depth);		
	}

}
