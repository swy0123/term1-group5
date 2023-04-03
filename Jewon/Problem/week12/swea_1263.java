package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
 * 
 * @author SSAFY
 *
 */
public class swea_1263 {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
//			int[][] adjMatrix = new int[N][N];
			int[][] dist = new int[N][N];

			int min_ans = Integer.MAX_VALUE;

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					int temp = Integer.parseInt(st.nextToken());

					if (temp == 1) {
//						adjMatrix[row][col] = temp;
						dist[row][col] = temp;
					} else {
//						adjMatrix[row][col] = INF;
						dist[row][col] = INF;
					}

				}
			}

			// 양 방향이라 비효율적이긴함.
			// 플로이드 워셜
			for (int i = 0; i < dist.length; i++) {
				for (int s = 0; s < dist.length; s++) {
					for (int e = 0; e < dist.length; e++) {
						if (s == e || i == s || i == e)
							continue;

						dist[s][e] = Math.min(dist[s][e], dist[s][i] + dist[i][e]);
					}
				}
			}

//			for (int i = 0; i < dist.length; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}

			for (int i = 0; i < dist.length; i++) {
				int sum = 0;
				for (int j = 0; j < dist.length; j++) {
					if (dist[i][j] != INF) {
						sum += dist[i][j];
					}
				}

				min_ans = Math.min(min_ans, sum);
			}
			System.out.println("#" + test_case + " " + min_ans);
		}
	}

}
