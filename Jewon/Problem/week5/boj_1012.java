import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_1012 유기농 배추 실버2
 * 
 * @author SSAFY
 *
 */
public class boj_1012 {
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int M;
	static int N;
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0;
			// 가로길이 M 세로길이 N 배추개수 K
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());

				map[row][col] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<Point>();

		q.add(new Point(i, j));
		map[i][j] = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			

			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
					q.offer(new Point(nr, nc));
					map[nr][nc] = 0;
				}
			}

		}

	}

}
