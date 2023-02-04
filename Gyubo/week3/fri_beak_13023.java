import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class fri_beak_13023 {

	private static boolean finishFlag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[n];
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			map.get(num1).add(num2);
			map.get(num2).add(num1);
		}
		// 입력종료

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(map, visited, 0, 4, i);
			visited[i] = false;
		}

		if (finishFlag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int currentDepth, int targetDepth,
			int value) {
		if (finishFlag) {
			return;
		}

		if (currentDepth == targetDepth) {
			finishFlag = true;
			return;
		}

		List<Integer> nexts = map.get(value);

		for (int i = 0; i < nexts.size(); i++) {
			Integer next = nexts.get(i);
			if (visited[next]) {
				continue;
			}

			visited[next] = true;
			dfs(map, visited, currentDepth + 1, targetDepth, next);
			visited[next] = false;
		}
	}
}
