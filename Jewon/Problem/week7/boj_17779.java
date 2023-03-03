package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_17779 게리맨더링 2 골드 3
 * 
 * @author SSAFY
 *
 */
public class boj_17779 {

	static int N;
	static int[][] population_map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int Ans = Integer.MAX_VALUE;
	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		population_map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr = new int[4];
		make_section(0);
		
		System.out.println(Ans);
	}

	static int[] arr; // x, y, d1, d2
	static int[] section_p_list;

	private static void make_section(int depth) {
		if (depth == 4) {
//			System.out.println(Arrays.toString(arr));
			// 구역 만들기
			make_map();

			// 값 계산하기
			section_p_list = new int[5];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					section_p_list[section_map[i][j] - 1] += population_map[i][j];
				}
			}
			
			Ans = Math.min(Ans, Arrays.stream(section_p_list).max().getAsInt() - Arrays.stream(section_p_list).min().getAsInt());
//			print(section_map);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (depth == 2) {
				if (arr[1] - i >= 1) {
					arr[depth] = i;
					make_section(depth + 1);
				}
			} else if (depth == 3) {
				if (arr[0] + arr[2] + i <= N && arr[1] <= N - i) {
					arr[depth] = i;
					make_section(depth + 1);
				}
			} else {
				arr[depth] = i;
				make_section(depth + 1);
			}
		}
	}

	private static void print(int[][] section_map2) {
		System.out.println("==============================");
		for (int i = 0; i < section_map2.length; i++) {
			for (int j = 0; j < section_map2.length; j++) {
				System.out.print(section_map2[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] section_map;

	private static void make_map() {
		section_map = new int[N][N];

		int x = arr[0] - 1;
		int y = arr[1] - 1;
		int d1 = arr[2];
		int d2 = arr[3];

//		section_map[x][y] = 5;
		// 경계선 만들기
		for (int i = 0; i <= d1; i++) {
			section_map[x + i][y - i] = 5;
			section_map[x + d2 + i][y + d2 - i] = 5;
		}

		for (int i = 0; i <= d2; i++) {
			section_map[x + i][y + i] = 5;
			section_map[x + d1 + i][y - d1 + i] = 5;
		}

		// 1
		int temp = 1;
		while (x - temp >= 0) {
			section_map[x - temp][y] = 1;
			temp++;
		}

		// 2
		temp = 1;
		while (y + d2 + temp < N) {
			section_map[x + d2][y + d2 + temp] = 2;
			temp++;
		}
		// 3
		temp = 1;
		while (y - d1 - temp >= 0) {
			section_map[x + d1][y - d1 - temp] = 3;
			temp++;
		}

		// 4
		temp = 1;
		while (x + d1 + d2 + temp < N) {
			section_map[x + d1+ d2 + temp][y - d1 + d2 ] = 4;
			temp++;
		}

		Queue<Point> q;
		// fill
		// 1
		q = new LinkedList<Point>();
		q.add(new Point(0, 0));
		section_map[0][0] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (section_map[nr][nc] == 0) {
						section_map[nr][nc] = 1;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		// 2
		q = new LinkedList<Point>();
		q.add(new Point(0, N - 1));
		section_map[0][N - 1] = 2;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (section_map[nr][nc] == 0) {
						section_map[nr][nc] = 2;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		// 3
		q = new LinkedList<Point>();
		q.add(new Point(N - 1, 0));
		section_map[N - 1][0] = 3;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (section_map[nr][nc] == 0) {
						section_map[nr][nc] = 3;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		// 4
		q = new LinkedList<Point>();
		q.add(new Point(N - 1, N - 1));
		section_map[N - 1][N - 1] = 4;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (section_map[nr][nc] == 0) {
						section_map[nr][nc] = 4;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		// 5
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (section_map[i][j] == 0) {
					section_map[i][j] = 5;
				}
			}
		}
	}

}
