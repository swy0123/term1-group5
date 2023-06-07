package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 
 * boj_4485 녹색 옷 입은 애가 젤다지? 골드4
 * 
 */

public class boj_4485 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Vertex implements Comparable<Vertex> {
		int row, col;
		int weight;

		public Vertex(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [row=" + row + ", col=" + col + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dist = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], INF);
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Vertex> q = new PriorityQueue<>();
			q.offer(new Vertex(0, 0, map[0][0]));
			dist[0][0] = map[0][0];

			while (!q.isEmpty()) {
				Vertex v = q.poll();

				if (visit[v.row][v.col]) {
					continue;
				}

				visit[v.row][v.col] = true;

				for (int d = 0; d < dir.length; d++) {
					int nr = v.row + dir[d][0];
					int nc = v.col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
						if (dist[nr][nc] > v.weight + map[nr][nc]) {
							dist[nr][nc] = v.weight + map[nr][nc];
							q.offer(new Vertex(nr, nc, dist[nr][nc]));
						}
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}

			System.out.println("Problem " + cnt + ": " + dist[N - 1][N - 1]);
			cnt++;
		}
	}

}
