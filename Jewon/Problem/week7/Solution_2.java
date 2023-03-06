import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2 {

	static int N;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static Point StartPoint;
	static int Ans;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						StartPoint = new Point(i, j);
					}
				}
			}

			visit = new boolean[N][N];
			map[StartPoint.row][StartPoint.col] = 0;
			solve(StartPoint, 0);

			System.out.println("#" + test_case + " " + Ans);
		}
	}

	private static void solve(Point startPoint, int depth) {
		if (depth == 3) {

			return;
		}

		int row = startPoint.row;
		int col = startPoint.col;
		// 상하좌우 찾아라
		for (int i = 0; i < dir.length; i++) {
			int temp = 1;
			boolean flag = false;
			while (true) {
				int nr = row + dir[i][0] * temp;
				int nc = col + dir[i][1] * temp;
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					
					// 뛰어라!
					if (flag && map[nr][nc] == 0) {
						solve(new Point(nr, nc), depth + 1);
					}

					
					// 잡아라!
					if (flag && map[nr][nc] == 1 ) {
						// 잡아라
						if(!visit[nr][nc]) { // 잡았던건 카운트 하지않아야한다.
							visit[nr][nc] = true;
							Ans++;
						}
						map[nr][nc] = 0;	
						solve(new Point(nr, nc), depth + 1);
						map[nr][nc] = 1;
						break;
						
					}
					
					// 넘어설수 있네!
					if (!flag && map[nr][nc] == 1) {
						flag = true;
					}
					
				} else { // 맵을 나가면 중단
					break;
				}
				temp++;
			}
		}

	}

}
