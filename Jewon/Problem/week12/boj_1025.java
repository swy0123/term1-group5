package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * boj_1025 제곱수 찾기
 * 
 */
public class boj_1025 {

	static int N, M;
	static int[][] map;
	static int Ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = sb.charAt(j) - '0';
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		// location
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//

				for (int rp = 1 - N; rp < N; rp++) {
					for (int cp = 1 - M; cp < M; cp++) {
						StringBuilder sb = new StringBuilder();

						if (rp == 0 && cp == 0) {
							if (map[i][j] == (int) Math.sqrt(map[i][j]) * (int) Math.sqrt(map[i][j])) {
								Ans = Math.max(Ans, map[i][j]);
							}
							continue;
						}

						int cnt = 0;

						while (true) {
							int nr = i + rp * cnt;
							int nc = j + cp * cnt;

							if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
								sb.append(map[nr][nc]);
							} else {
								break;
							}

							cnt++;
						}

						
						for (int k = 0; k < sb.length(); k++) {
							int temp = Integer.parseInt(sb.toString().substring(0, sb.length()-k));
							if (temp == (int) Math.sqrt(temp) * (int) Math.sqrt(temp)) {
								Ans = Math.max(Ans, temp);
							}							
						}
					}
				}
			}
		}

		System.out.println(Ans);
	}

}
