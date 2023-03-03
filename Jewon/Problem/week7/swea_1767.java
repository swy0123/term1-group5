package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * swea_1767 [SW Test 샘플문제] 프로세서 연결하기
 * 
 * @author SSAFY
 *
 */
public class swea_1767 {
	// 상하좌우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N;
	static int[][] map;

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static List<Point> Processor_points;
	static boolean[] checkList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Processor_points = new ArrayList<Point>();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						Processor_points.add(new Point(i, j));
					}
				}
			}

			// 끝에 있으면 고려할 필요가 없음
			for (int i = 0; i < Processor_points.size(); i++) {
				Point p = Processor_points.get(i);
				if (p.row == 0 || p.row == N - 1 || p.col == 0 || p.col == N - 1) {
					Processor_points.remove(i);
					i--;
				}
			}

			checkList = new boolean[Processor_points.size()];

			//
			arr = new int[Processor_points.size()];
			make_perm(0);
		}
	}

	static int[] arr;
	static int[][] map_copy;

	private static void make_perm(int depth) {
		if (depth == Processor_points.size()) {
			System.out.println(Arrays.toString(arr));

			// map_copy
			map_copy();
			// 각 프로세스의 방향을 뽑았으니 되는지 시뮬 돌리기
			for (int i = 0; i < arr.length; i++) {
				int result = line_fill(map_copy, arr[i], Processor_points.get(i));
			}

			return;
		}

		for (int d = 0; d < dir.length; d++) {
			arr[depth] = d;
			make_perm(depth + 1);
		}
	}

	private static void map_copy() {
		map_copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
	}

	private static int line_fill(int[][] map_copy, int dir, Point point) {
		int temp = 1;
		int row = point.row;
		int col = point.col;
		while (true) {

		}

		return 0;
	}

}
