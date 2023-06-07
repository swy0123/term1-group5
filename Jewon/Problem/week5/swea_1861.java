package pkg02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * swea_1861 정사각형 방 D4
 * 
 * @author SSAFY
 *
 */

public class swea_1861 {
	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
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

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("1861. 정사각형 방.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int anslevel = Integer.MIN_VALUE;
			int ansNum = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = bfs(i, j);
					if (anslevel == temp && map[i][j] < ansNum) {
						ansNum = map[i][j];
						anslevel = temp;
					}else if(anslevel < temp) {
						ansNum = map[i][j];
						anslevel = temp;
					}
				}
			}

			// 방 번호와 이동 개수 level 출력
			System.out.println("#" + test_case + " " + ansNum + " " + anslevel);
			//print();
		}
	}

	private static void print() {
		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int bfs(int row, int col) {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(new Point(row, col));
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int cnt = 0; cnt < size; cnt++) {
				Point p = q.poll();

				for (int i = 0; i < dir.length; i++) {
					int nr = p.row + dir[i][0];
					int nc = p.col + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] - map[p.row][p.col] == 1) {
						q.offer(new Point(nr, nc));
					}
				}

			}
			level++;
		}

		return level;
	}

}
