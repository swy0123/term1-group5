package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_17472 다리만들기 2
 * @author SSAFY
 *
 */
public class boj_17472 {
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

	static class Vertex implements Comparable<Vertex> {
		int end, weight;

		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N, M;
	static int[][] map;
	static int[][] adjMatrix;
	static List<Vertex> adjList[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}

		// numbering
		int number = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					numbering(i, j, number++);
				}
			}
		}

//		print(map);

		// make adjMatrix
		adjMatrix = new int[number][number];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					search_land(i, j);
				}
			}
		}

//		print(adjMatrix);

		// adjMatrix => adjList
		adjList = new ArrayList[number];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < adjMatrix.length; i++) {
			for (int j = i + 1; j < adjMatrix[i].length; j++) {
				if (adjMatrix[i][j] != 0) {
					adjList[i].add(new Vertex(j, adjMatrix[i][j]));
					adjList[j].add(new Vertex(i, adjMatrix[i][j]));
				}
			}
		}

//		for (int i = 1; i < adjList.length; i++) {
//			System.out.println(Arrays.toString(adjList[i].toArray()));
//		}

		// MST Prim
		boolean[] visit = new boolean[number];
		int[] nodes = new int[number];
		Arrays.fill(nodes, Integer.MAX_VALUE);
		
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.addAll(adjList[1]);
		visit[1] = true;
		nodes[1] = 0;
		int cnt = 1;
		
		while(cnt < number-1 && !q.isEmpty()) {
			Vertex v = q.poll();
			if(visit[v.end]) continue;
			visit[v.end] = true;
			
			nodes[v.end] = v.weight;
			cnt++;
			q.addAll(adjList[v.end]);
		}
		
		int sum = 0;
		for (int i = 1; i < nodes.length; i++) {
			if(nodes[i] == Integer.MAX_VALUE) {
				sum = -1;
				break;
			}
			
			sum += nodes[i];
		}
		
		System.out.println(sum);
		
	}

	private static void search_land(int row, int col) {

		for (int i = 0; i < dir.length; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];
			int dist = 1;
			while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				nr += dir[i][0];
				nc += dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && dist >= 2) {
					// map[row][col] -> map[nr][nc]
					int a = map[row][col];
					int b = map[nr][nc];
					if (adjMatrix[a][b] == 0) {
						adjMatrix[a][b] = dist;
						adjMatrix[b][a] = dist;
					} else {
						if (adjMatrix[a][b] > dist) {
							adjMatrix[a][b] = dist;
							adjMatrix[b][a] = dist;
						}
					}
				}

				dist++;
			}
		}
	}

	private static void print(int[][] map_print) {
		for (int i = 0; i < map_print.length; i++) {
			System.out.println(Arrays.toString(map_print[i]));
		}
	}

	private static void numbering(int i, int j, int k) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i, j));
		map[i][j] = k;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < dir.length; d++) {
				int nr = p.row + dir[d][0];
				int nc = p.col + dir[d][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == -1) {
					map[nr][nc] = k;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
}
