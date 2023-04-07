import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14500 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	static int N, M;
	static int[][] map;
	static int[][] visit;
	static Point temp;
	static int Ans = -1;
	static int max_value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new Point(-1, -1);

		map = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				max_value = Math.max(max_value, map[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] += 1;
				dfs(i, j, 1, map[i][j]);
				visit[i][j] -= 1;
			}
		}

		System.out.println(Ans);
	}

	private static void dfs(int row, int col, int depth, int sum) {
		if(Ans >= sum + (4 - depth) * max_value) return;
		
		if (depth == 4) {
			Ans = Math.max(Ans, sum);
			return;
		}

		for (int d = 0; d < dir.length; d++) {
			int nr = row + dir[d][0];
			int nc = col + dir[d][1];

			if (isRange(nr, nc) && visit[nr][nc] < 2) {
				if (visit[nr][nc] == 0) {
					visit[nr][nc]++;
					dfs(nr, nc, depth + 1, sum + map[nr][nc]);
					visit[nr][nc]--;
				} else if (visit[nr][nc] == 1) {
					visit[nr][nc]++;
					dfs(nr, nc, depth, sum);
					visit[nr][nc]--;
				}
			}
		}
	}

	private static boolean isRange(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}

}
