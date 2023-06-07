import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class tue_beak_1012 {

	private static final int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] table = new int[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				table[y][x] = 1;
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (table[i][j] == 1) {
						bfs(table, i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int[][] table, int y, int x) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });

		while (!q.isEmpty()) {
			int[] currentCoord = q.poll();
			int cy = currentCoord[0];
			int cx = currentCoord[1];

			if (table[cy][cx] == 0) {
				continue;
			}
			table[cy][cx] = 0;

			for (int i = 0; i < move.length; i++) {
				int ny = cy + move[i][0];
				int nx = cx + move[i][1];

				if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
					continue;
				}

				q.add(new int[] { ny, nx });
			}
		}
	}
}
