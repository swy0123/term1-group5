import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int M;
	static int[][] map;

	static class Point {
		int row;
		int col;

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

	static List<Point> Virus;
	static int Ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					Virus.add(new Point(i, j));
				}
			}
		}

		dfs(0, 0, 0);
		
		System.out.println(Ans);
	}

	private static void dfs(int row, int col, int depth) {
		if (depth == 3) {
			bfs();
			return;
		}

		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 1 && map[i][j] != 2) {
					map[i][j] = 1;
					dfs(i, j, depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		q.addAll(Virus);
		boolean[][] visit = new boolean[N][M];

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (visit[p.row][p.col]) {
				continue;
			}

			visit[p.row][p.col] = true;
			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visit[nr][nc] && map[nr][nc] != 1) {
						q.offer(new Point(nr, nc));
					}

				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0 && !visit[i][j]) {
					cnt++;
				}
			}
		}
		Ans = Integer.max(Ans, cnt);
	}

}