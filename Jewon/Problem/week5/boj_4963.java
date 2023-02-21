import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_4963 섬의 개수 실버 2
 * 
 * @author SSAFY
 *
 */
public class boj_4963 {

	static int[][] map;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int W;
	static int H;

	static class Point {
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
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) {
				return;
			}
			
			
			int cnt = 0;

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						//print();
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	private static void print() {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<Point>();

		q.add(new Point(i, j));
		map[i][j] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 8; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];

				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 1) {
					q.offer(new Point(nr, nc));
					map[nr][nc] = 0;
				}
			}

		}

	}

}
