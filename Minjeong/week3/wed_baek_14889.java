import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<List<Integer>> list = new ArrayList<>();
	private static int[] res = new int[11];
	private static boolean[] visited = new boolean[21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		devide(0, 0, n);
		
		int min = 10000;
		for (List<Integer> team : list) {
			int team_a = 0, team_b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					if (team.contains(i + 1) && team.contains(j + 1)) {
						team_a += arr[i][j];
					}
					else if (!team.contains(i + 1) && !team.contains(j + 1)) {
						team_b += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(team_a - team_b));
		}
		System.out.println(min);
	}
	
	private static void devide(int pos, int depth, int n) {
		if (depth == n / 2) {
			list.add(new ArrayList<Integer>());
			for (int i = 0; i < n / 2; i++) {
				list.get(list.size() - 1).add(res[i]);
			}
			return;
		}
		
		for (int i = pos; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			res[depth] = i + 1;
			devide(i + 1, depth + 1, n);
			visited[i] = false;
		}
	}
}
