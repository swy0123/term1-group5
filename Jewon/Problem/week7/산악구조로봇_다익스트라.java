package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단 거리 그리디 하게 접근
// Vertex를 만들고 , 소모 연료값 넣기 
public class 산악구조로봇_다익스트라 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N;
	static int[][] map;
	static int used_fuel = Integer.MAX_VALUE;

	static class Vertex implements Comparable<Vertex> {
		int row;
		int col;

		int using_fuel;

		public Vertex(int row, int col, int using_fuel) {
			super();
			this.row = row;
			this.col = col;
			this.using_fuel = using_fuel;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.using_fuel, o.using_fuel);
		}

		@Override
		public String toString() {
			return "Vertex [row=" + row + ", col=" + col + ", using_fuel=" + using_fuel + "]";
		}

	}

	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
			q.offer(new Vertex(0, 0, 0));
			dist[0][0] = 0;

			while (!q.isEmpty()) {
				Vertex v = q.poll();

				if (visited[v.row][v.col]) {
					continue;
				}

				visited[v.row][v.col] = true;
				for (int i = 0; i < dir.length; i++) {
					int nr = v.row + dir[i][0];
					int nc = v.col + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (!visited[nr][nc]) {
							int temp_fuel = map[nr][nc] - map[v.row][v.col];
							if (temp_fuel < 0) {
								temp_fuel = 0;
							} else if (temp_fuel == 0) {
								temp_fuel = 1;
							} else if (temp_fuel > 0) {
								temp_fuel *= 2;
							}

							if (dist[nr][nc] > dist[v.row][v.col] + temp_fuel) {
								dist[nr][nc] = dist[v.row][v.col] + temp_fuel;
								q.offer(new Vertex(nr, nc, v.using_fuel + temp_fuel));
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + dist[N - 1][N - 1]);
		}

	}
}
