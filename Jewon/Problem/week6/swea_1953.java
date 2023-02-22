package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * swea_1953 [모의 SW 역량테스트] 탈주범 검거
 * 
 * @author SSAFY
 *
 */
public class swea_1953 {
	static int[][] map;

	// 상 하 좌 우 0 1 2 3
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] pipedir = {{}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	// 이동이 이동한것과 맞는가
	// 상 하 좌 우
	static int[][] pipe = { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };

	static class Point {
		int row;
		int col;
		
		int pipe = -1;
		
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		

		public Point(int row, int col, int pipe) {
			super();
			this.row = row;
			this.col = col;
			this.pipe = pipe;
		}



		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	static int N;
	static int M;
	static int mhollRow;
	static int mhollCol;
	static int L;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			mhollRow = Integer.parseInt(st.nextToken());
			mhollCol = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			cnt = 1;
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// search start point mhollRow mhollCol
			BFS();

			// go!
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void BFS() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(mhollRow, mhollCol, map[mhollRow][mhollCol]));
		map[mhollRow][mhollCol] = 0;
		int level = 0;

		while (!q.isEmpty() && level < L-1) {
			int size = q.size();
//			System.out.println("level : " + level + Arrays.toString(q.toArray()) + "cnt : " + cnt );
			
			for (int round = 0; round < size; round++) {
				Point p = q.poll();
				
				
				int currentpipe = p.pipe;
				for (int i = 0; i < pipedir[currentpipe].length; i++) {
					int nr = p.row + dir[pipedir[currentpipe][i]][0];
					int nc = p.col + dir[pipedir[currentpipe][i]][1];
					
//					map[p.row][p.col] = 0;
					// 좌표에 들어와 있으며, 파이프가 있는지, 해당 파이프랑 연결이 되는지 확인하기
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0
							&& check_pipe(pipedir[currentpipe][i], nr, nc)) {
						q.offer(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;
						cnt++;
					}

				}

			}

			level++;
		}
//		System.out.println("level : " + level + Arrays.toString(q.toArray()) + "cnt : " + cnt );
	}

	private static boolean check_pipe(int dir, int nr, int nc) {
		// TODO Auto-generated method stub

		// pipe[dir]
		for (int i = 0; i < pipe[dir].length; i++) {
			if (pipe[dir][i] == map[nr][nc]) {
				return true;
			}
		}

		return false;
	}

}
