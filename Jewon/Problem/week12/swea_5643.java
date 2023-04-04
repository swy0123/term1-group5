import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 
 * swea_5643 키순서
 * 
 * @author elder
 *
 */
public class swea_5643 {

	static int N, M;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 학생수
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 비교수

			dist = new int[N][N];
			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], INF);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				dist[a][b] = 1;
			}

			// 플로이드 워셜
			for (int i = 0; i < dist.length; i++) {
				for (int s = 0; s < dist.length; s++) {
					for (int e = 0; e < dist.length; e++) {
						if (i == s || i == e || s == e)
							continue;

						dist[s][e] = Math.min(dist[s][e], dist[s][i] + dist[i][e]);
					}
				}
			}

//			for (int i = 0; i < dist.length; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			
			int cnt = 0;
			//check
			outer : for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist.length; j++) {
					if(i == j) continue;
					
					if(dist[i][j] == INF && dist[j][i] == INF) {
						continue outer;
					}
				}
				cnt++;
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}

}
