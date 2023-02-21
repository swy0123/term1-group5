import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_2667 단지번호붙이기 실버 1
 * 
 * @author SSAFY
 *
 */

public class boj_2667 {
	static int[][] map;
	static List<Integer> list = new ArrayList<Integer>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = sb.charAt(j) - '0';
			}
		}
		
		//print();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					list.add(bfs(i, j));
				}
			}
		}

		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static Integer bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i, j));
		map[i][j] = 0;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			cnt++;
			
			for (int d = 0; d < dc.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
					q.offer(new Point(nr, nc));
					map[nr][nc] = 0;
				}
			}
		}

		return cnt;
	}
}
