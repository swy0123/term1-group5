import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n;
	static char[][] map;
	static int[][] del = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.print(solve1() + " ");
		System.out.println(solve2());
	}

	private static int solve1() {
		int cnt = 0;
		boolean[][] v1 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v1[i][j]) {
					bfs1(i, j, v1);
					if (map[i][j] == 'G') map[i][j] = 'R';
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static int solve2() {
		int cnt = 0;
		boolean[][] v2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v2[i][j]) {
					bfs2(i, j, v2);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs1(int x, int y, boolean[][] v) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(x, y));
		v[x][y] = true;

		while (!q.isEmpty()) {
			int curX = q.peek().x;
			int curY = q.poll().y;
			for (int i = 0; i < 4; i++) {
				int nx = curX + del[i][0];
				int ny = curY + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n
						|| v[nx][ny] || map[x][y] != map[nx][ny]) continue;
				v[nx][ny] = true;
				if (map[nx][ny] == 'G') map[nx][ny] = 'R';
				q.offer(new Pair(nx, ny));
			}
		}
	}
	
	private static void bfs2(int x, int y, boolean[][] v) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(x, y));
		v[x][y] = true;

		while (!q.isEmpty()) {
			int curX = q.peek().x;
			int curY = q.poll().y;
			for (int i = 0; i < 4; i++) {
				int nx = curX + del[i][0];
				int ny = curY + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n
						|| v[nx][ny] || map[x][y] != map[nx][ny]) continue;
				v[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}