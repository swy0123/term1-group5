import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_7576 토마토 골드5
 * 
 * @author SSAFY
 *
 */
public class boj_7576 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int ans;
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 저장될때 부터 모두 익었으면 0
		if(check()) {
			System.out.println(0);
			return;
		}
		
		
		ans = bfs();

		// 모두 익었는지 확인하기
		if (check()) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}

	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<Point>();

		// search tomato
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}

		int level = -1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int cnt = 0; cnt < size; cnt++) {
				Point p = q.poll();

				for (int i = 0; i < dir.length; i++) {
					int nr = p.x + dir[i][0];
					int nc = p.y + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
						q.offer(new Point(nr, nc));
						map[nr][nc] = 1;
					}
				}
			}
			level++;
		}

		return level;
	}

}
