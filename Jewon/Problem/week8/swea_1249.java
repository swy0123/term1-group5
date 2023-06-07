import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 1249. [S/W 문제해결 응용] 4일차 - 보급로
 * 
 * @author SSAFY
 *
 */
public class swea_1249 {

	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int INF = Integer.MAX_VALUE;

	static class Point implements Comparable<Point> {
		int row;
		int col;
		int weight;

		public Point(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}

			for (int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = sb.charAt(j) - '0';
				}
			}
			//
			PriorityQueue<Point> q = new PriorityQueue<Point>();
			q.offer(new Point(0, 0, 0));
			dist[0][0] = 0;
			
			while (!q.isEmpty()) {
				Point p = q.poll();

				if (visited[p.row][p.col]) {
					continue;
				}
				

				visited[p.row][p.col] = true;
				for (int i = 0; i < dir.length; i++) {
					int nr = p.row + dir[i][0];
					int nc = p.col + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						// 정점에 포함 하지 않았으며 	 목표까지 찾은 최소거리  >  현재 까지 걸린 거리 + 목표거리
						if (!visited[nr][nc] && dist[nr][nc] > dist[p.row][p.col] + map[nr][nc]) {
							dist[nr][nc] = dist[p.row][p.col] + map[nr][nc];
							q.offer(new Point(nr, nc, dist[nr][nc]));
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + dist[N - 1][N - 1]);
		}
	}

}
