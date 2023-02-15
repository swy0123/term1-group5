import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static int n, res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 라벨링
		int label = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, label++);
				}
			}
		}

		// 다리 연결
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) continue;

				for (int k = 0; k < 4; k++) {
					int nx = i + del[k][0];
					int ny = j + del[k][1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == map[i][j]) continue;
					res = Math.min(res, find(nx, ny, map[i][j]));
				}
			}
		}

		System.out.println(res);
	}

	private static void bfs(int st, int sy, int label) {
		Queue<Pair> q = new ArrayDeque<>();
		map[st][sy] = label;
		q.offer(new Pair(st, sy));

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int i = 0; i < 4; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = label;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}
	
	private static int find(int st, int sy, int label) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(st, sy));
		boolean[][] v = new boolean[n][n];
		v[st][sy] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			if (cnt >= res) return Integer.MAX_VALUE;
			
			while (size-- > 0) {
				int x = q.peek().x;
				int y = q.poll().y;

				for (int i = 0; i < 4; i++) {
					int nx = x + del[i][0];
					int ny = y + del[i][1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					if (map[nx][ny] == 0) {
						if (!v[nx][ny]) {
							q.offer(new Pair(nx, ny));
							v[nx][ny] = true;
						}
					} 
					else if (map[nx][ny] != label) return cnt;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
