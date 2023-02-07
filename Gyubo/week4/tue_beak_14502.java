import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class tue_beak_14502 {
	private static final int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static int[][] graph;
	private static final List<int[]> virusCoords = new ArrayList<>();
	private static final List<int[]> blankCoords = new ArrayList<>();
	private static int maxValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 0) {
					blankCoords.add(new int[] { i, j });
				} else if (input == 2) {
					virusCoords.add(new int[] { i, j });
				}
				graph[i][j] = input;
			}
		}
		combination(0, new int[3][2], 0);

		System.out.println(maxValue);
	}

	private static void combination(int depth, int[][] results, int index) {
		// 3개를 고르면 bfs 실행
		if (depth == results.length) {
			maskGraph(results, 1);
			bfs();
			maskGraph(results, 0);
			return;
		}
		for (int i = index; i < blankCoords.size(); i++) {
			int[] blankCoord = blankCoords.get(i);
			results[depth] = blankCoord;
			combination(depth + 1, results, i + 1);
		}
	}

	private static void bfs() {
		List<int[]> result = new ArrayList<>();

		for (int[] virusCoord : virusCoords) {
			Deque<int[]> deque = new ArrayDeque<>();
			deque.add(virusCoord);

			while (!deque.isEmpty()) {
				int[] currentCoord = deque.pollFirst();

				for (int i = 0; i < move.length; i++) {
					int ny = currentCoord[0] + move[i][0];
					int nx = currentCoord[1] + move[i][1];

					if (ny < 0 || ny >= graph.length || nx < 0 || nx >= graph[0].length) {
						continue;
					}
					if (graph[ny][nx] != 0) {
						continue;
					}

					int[] newCoord = { ny, nx };
					result.add(newCoord);
					deque.addLast(newCoord);
					graph[ny][nx] = 2;
				}
			}
		}

		updateMaxValue();
		maskGraph(result.toArray(new int[0][0]), 0);
	}

	private static void updateMaxValue() {
		int count = 0;
		for (int[] row : graph) {
			for (int value : row) {
				if (value == 0) {
					count++;
				}
			}
		}

		maxValue = Math.max(count, maxValue);
	}

	private static void maskGraph(int[][] results, int value) {
		for (int[] result : results) {
			graph[result[0]][result[1]] = value;
		}
	}
}
