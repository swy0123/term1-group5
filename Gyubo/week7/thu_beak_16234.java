import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 인구 이동
public class thu_beak_16234 {

	private static final int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] table = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (true) {
			boolean flag = false;
			boolean[][][] dir = new boolean[n][n][4];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int d = 0; d < move.length; d++) {
						int ny = i + move[d][0];
						int nx = j + move[d][1];

						if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
							continue;
						}
						int diff = Math.abs(table[ny][nx] - table[i][j]);
						if (l <= diff && diff <= r) {
							dir[i][j][d] = true;
							flag = true;
						}

					}
				}
			}

			if (!flag) {
				break;
			}

			count++;
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(table, visited, dir, i, j);
					}
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs(int[][] table, boolean[][] visited, boolean[][][] dir, int y, int x) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		visited[y][x] = true;

		int sum = 0;
		List<int[]> coords = new ArrayList<>();

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cy = p[0];
			int cx = p[1];

			sum += table[cy][cx];
			coords.add(new int[] { cy, cx });

			for (int d = 0; d < move.length; d++) {
				if (!dir[cy][cx][d]) {
					continue;
				}
				int ny = cy + move[d][0];
				int nx = cx + move[d][1];

				if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });
			}
		}

		int value = sum / coords.size();
		for (int[] coord : coords) {
			table[coord[0]][coord[1]] = value;
		}
	}
}
