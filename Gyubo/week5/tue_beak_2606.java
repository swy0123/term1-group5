import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 바이러스
public class tue_beak_2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j) {
					graph[i][j] = 0;
					continue;
				}
				graph[i][j] = 999;
			}
		}

		int v = Integer.parseInt(br.readLine());
		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}

		int count = -1;
		for (int i = 1; i < n + 1; i++) {
			if (graph[1][i] != 999) {
				count++;
			}
		}
		System.out.println(count);
	}
}
