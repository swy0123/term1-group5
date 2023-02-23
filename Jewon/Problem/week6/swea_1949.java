package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * swea_1949 [모의 SW 역량테스트] 등산로 조성
 * 
 * @author SSAFY
 *
 */
public class swea_1949 {
	static int N;
	static int K;
	static int[][] map;
	static int maxHeight = Integer.MIN_VALUE;

	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static List<Point> list;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			list = new ArrayList();

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					//
					if (maxHeight < map[i][j]) {
						maxHeight = map[i][j];
						list = new ArrayList();
						list.add(new Point(i, j));

					} else if (maxHeight == map[i][j]) {
						list.add(new Point(i, j));
					}

				}
			}

			for (int i = 0; i < list.size(); i++) {
				// 높
				dfs(list.get(i).row, list.get(i).col, map[list.get(i).row][list.get(i).col], 0, true);
			}
			
			System.out.println(ans);
		}
	}

	private static void dfs(int row, int col, int height, int depth, boolean sovel) {
		// 높은곳 부터 탐색하며 내려감.
		// 아직 삽이 있으면 앞에 산을 깎아 버림
		// 이러한 모든 경우의 수를 탐색해서 최대한 값을 탐색해야함
		boolean flag = false;
		
		for (int i = 0; i < dir.length; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (height > map[nr][nc]) {
					dfs(nr, nc, map[nr][nc], depth + 1, sovel);
					flag = true;
				} else if (sovel == true && map[nr][nc] - K < height) {
					// map[nr][nc]  - (map[nr][nc] - height + 1)
					dfs(nr,nc, map[nr][nc]  - (map[nr][nc] - height + 1), depth+1, !sovel);
					flag = true;
				}
			}
		}
		
		if(flag) {
			System.out.println(row + " " + col);
			ans = Math.max(ans, depth);
		}

	}

}
