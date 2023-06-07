import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 벽돌 깨기
public class thu_swea_5656 {

	static class Block {
		int y;
		int x;
		int range;

		public Block(int y, int x, int range) {
			super();
			this.y = y;
			this.x = x;
			this.range = range;
		}

		public void explode(int[][] copied, Deque<Block> q) {
			// 각 지점을 탐색해서 0 이 아닌것이라면 q에 추가
			for (int i = 1; i < range; i++) {
				for (int d = 0; d < dir.length; d++) {
					int ny = this.y + dir[d][0] * i;
					int nx = this.x + dir[d][1] * i;

					if (ny < 0 || nx < 0 || ny >= copied.length || nx >= copied[0].length) {
						continue;
					}

					if (copied[ny][nx] != 0) {
						q.add(new Block(ny, nx, copied[ny][nx]));
						copied[ny][nx] = 0;
					}
				}
			}
		}
	}

	private static List<int[]> permus;
	private static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static int minValue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < testCase + 1; tc++) {
			minValue = Integer.MAX_VALUE;
			permus = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			int[][] table = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			permutationWithRe(new int[n], 0, w);
			for (int[] startXs : permus) {
				int[][] copied = copyTable(table);
				for (int startX : startXs) {
					Block firstBlock = findFirstBolck(startX, copied);
					if (firstBlock == null) {
						continue;
					}

					Deque<Block> q = new ArrayDeque<>();
					q.add(firstBlock);
					while (!q.isEmpty()) {
						Block p = q.poll();
						p.explode(copied, q);
					}
					applyGravity(table, copied);
					updateMinValue(copied);
				}
			}
			System.out.println("#" + tc + " " + minValue);
		}
	}

	private static void updateMinValue(int[][] copied) {
		int count = 0;
		for (int i = 0; i < copied.length; i++) {
			for (int j = 0; j < copied[0].length; j++) {
				if (copied[i][j] != 0) {
					count++;
				}
			}
		}
		minValue = Math.min(count, minValue);
	}

	private static void applyGravity(int[][] table, int[][] copied) {
		for (int i = 0; i < table[0].length; i++) {
			List<Integer> tmpList = new ArrayList<>();
			for (int j = table.length - 1; j >= 0; j--) {
				if (copied[j][i] != 0) {
					tmpList.add(copied[j][i]);
				}
			}

			int count = 0;
			for (int j = table.length - 1; j >= 0; j--) {
				if (count == tmpList.size()) {
					copied[j][i] = 0;
				} else {
					copied[j][i] = tmpList.get(count);
					count++;
				}
			}
		}
	}
	
	private static int[][] copyTable(int[][] table) {
		int[][] clone = new int[table.length][table[0].length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				clone[i][j] = table[i][j];
			}
		}
		return clone;
	}

	private static Block findFirstBolck(int x, int[][] table) {
		for (int y = 0; y < table.length; y++) {
			if (table[y][x] != 0) {
				Block block = new Block(y, x, table[y][x]);
				table[y][x] = 0;
				return block;
			}
		}
		return null;
	}

	private static void permutationWithRe(int[] result, int depth, int w) {
		if (result.length == depth) {
			permus.add(Arrays.copyOf(result, result.length));
			return;
		}
		for (int i = 0; i < w; i++) {
			result[depth] = i;
			permutationWithRe(result, depth + 1, w);
		}
	}
}
