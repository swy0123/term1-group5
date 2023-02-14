import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class tue_beak_4963 {

	private static final int[][] move = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			int[][] table = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
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
