import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// boj_13460 구슬 탈출 2

public class boj_13460 {
	static class Point {
		int row, col;
		char color;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public Point(Point point) {
			super();
			this.row = point.row;
			this.col = point.col;
			this.color = point.color;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;
	static char[][] map;

	static Point Redball;
	static Point Blueball;
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = sb.charAt(j);

				if (map[i][j] == 'B') {
					Blueball = new Point(i, j);
					Blueball.color = 'B';
				}

				if (map[i][j] == 'R') {
					Redball = new Point(i, j);
					Redball.color = 'R';
				}
			}
		}

		dfs(0, map, Redball, Blueball);

		if (Ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Ans);
		}
	}

	private static void dfs(int depth, char[][] map, Point redball, Point blueball) {
		// 가지 치기 이미 구해진 횟수보라 많이 굴리려고 할때
		if (depth > Ans) {
			return;
		}

		// 공 확인하기

		// 빨간공만 사라짐 GOOD
		if (redball.row == -1 && blueball.row != -1) {
			Ans = Math.min(Ans, depth);
			return;
		}

		// 파란 공만 사라짐 Fail
		if (redball.row != -1 && blueball.row == -1) {
			return;
		}

		// 둘다 사라짐 Fail
		if (redball.row == -1 && blueball.row == -1) {
			return;
		}

		if (depth == 10) {
			return;
		}

		for (int d = 0; d < dir.length; d++) {
			// 상하좌우 굴리기

			// 클론
			char[][] clone_map = clone_map(map);
			Point clone_redball = new Point(redball);
			Point clone_blueball = new Point(blueball);

			// 이동 시키기
			move(clone_map, clone_redball, clone_blueball, d);
//			print(clone_map, clone_redball, clone_blueball , depth, d);

			// 공이 이동하지 않았으면 XX
			if (redball.row == clone_redball.row && redball.col == clone_redball.col
					&& blueball.row == clone_blueball.row && blueball.col == clone_blueball.col) {
				continue;
			}

			// dfs
			dfs(depth + 1, clone_map, clone_redball, clone_blueball);
		}
	}

	private static void print(char[][] clone_map, Point clone_redball, Point clone_blueball, int depth, int dir) {
		System.out.println();
		System.out.println("level : " + (depth + 1) + " dir : " + dir);
		System.out.println(" R : " + clone_redball);
		System.out.println(" B : " + clone_blueball);

		for (int i = 0; i < clone_map.length; i++) {
			System.out.println(Arrays.toString(clone_map[i]));
		}
	}

	private static void move(char[][] clone_map, Point clone_redball, Point clone_blueball, int d) {
		Point firstball = null;
		Point secoundball = null;

		// 먼저 굴릴 공 선택
		switch (d) {
		case 0: // 상

			if (clone_redball.row < clone_blueball.row) {
				firstball = clone_redball;
				secoundball = clone_blueball;
			} else {
				firstball = clone_blueball;
				secoundball = clone_redball;
			}

			break;
		case 1: // 하

			if (clone_redball.row > clone_blueball.row) {
				firstball = clone_redball;
				secoundball = clone_blueball;
			} else {
				firstball = clone_blueball;
				secoundball = clone_redball;
			}

			break;
		case 2: // 좌

			if (clone_redball.col < clone_blueball.col) {
				firstball = clone_redball;
				secoundball = clone_blueball;
			} else {
				firstball = clone_blueball;
				secoundball = clone_redball;
			}

			break;
		case 3: // 우

			if (clone_redball.col > clone_blueball.col) {
				firstball = clone_redball;
				secoundball = clone_blueball;
			} else {
				firstball = clone_blueball;
				secoundball = clone_redball;
			}

			break;
		}

		// 공을 굴린다.

		// first ball
		clone_map[firstball.row][firstball.col] = '.';

		int cnt = 1;
		while (true) {
			int nr = firstball.row + (dir[d][0]);
			int nc = firstball.col + (dir[d][1]);
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (clone_map[nr][nc] == '.') {
					firstball.row = nr;
					firstball.col = nc;
					cnt++;
					continue;
				}

				if (clone_map[nr][nc] == 'O') {
					firstball.row = -1;
					firstball.col = -1;
					break;
				}

				// 다른 공을 만났을때 , 벽을 만났을때
				break;
			}
			break;
		}

		// 공 위치 업데이트
		if (firstball.row != -1 && firstball.col != -1) {
			clone_map[firstball.row][firstball.col] = firstball.color;
		}

		// secound ball
		clone_map[secoundball.row][secoundball.col] = '.';

		cnt = 1;
		while (true) {
			int nr = secoundball.row + (dir[d][0]);
			int nc = secoundball.col + (dir[d][1]);
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (clone_map[nr][nc] == '.') {
					secoundball.row = nr;
					secoundball.col = nc;
					cnt++;
					continue;
				}

				if (clone_map[nr][nc] == 'O') {
					secoundball.row = -1;
					secoundball.col = -1;
					break;
				}

				// 다른 공을 만났을때 , 벽을 만났을때
				break;
			}
			break;
		}

		// 공 위치 업데이트
		if (secoundball.row != -1 && secoundball.col != -1) {
			clone_map[secoundball.row][secoundball.col] = secoundball.color;
		}
	}

	private static char[][] clone_map(char[][] map) {
		char[][] clone_map = new char[map.length][map[0].length];

		for (int i = 0; i < clone_map.length; i++) {
			for (int j = 0; j < clone_map[i].length; j++) {
				clone_map[i][j] = map[i][j];
			}
		}
		return clone_map;
	}

}
