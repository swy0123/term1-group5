package pkg02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_14890 경사로 골드3
 * 
 * @author SSAFY
 *
 */
public class boj_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;

		// 왼쪽에서 오른쪽으로 탐색
		for (int i = 0; i < N; i++) {
			// 출발
			int cnt = 1;
			int prev = map[i][0];
			boolean flag_down = true;
			boolean check_all = true;
			for (int j = 1; j < N; j++) {
				if (flag_down) { // 내려 가는 중인가?
					if (prev == map[i][j]) { // 같을때
						cnt++;
					} else if (prev < map[i][j] && map[i][j] - prev == 1 && cnt >= L) { // 높을때
						prev = map[i][j];
						cnt = 1;
					} else if (prev > map[i][j] && prev - map[i][j] == 1) { // 낮을때
						if (L == 1) {
							flag_down = true;
							cnt = 0;
						} else {
							flag_down = false;
							cnt = 1;
						}
						prev = map[i][j];
					} else { // 길이 안댐
						check_all = false;
						break;
					}
				} else { // 내려가는중
					if (prev == map[i][j]) { // 같음
						cnt++;
						if (cnt == L) { // L만큼 왔음
							flag_down = true;
							cnt = 0;
						}
					} else { // 다름
						check_all = false;
						break;
					}
				}
			}
			// flag_down == false && cnt < L
			if (check_all) {
				if (flag_down == false && cnt < L) {

				} else {
					ans++;
				}
			}
		}

		// 위에서 아래로 탐색
		for (int j = 0; j < N; j++) {
			// 출발
			int cnt = 1;
			int prev = map[0][j];
			boolean flag_down = true;
			boolean check_all = true;
			for (int i = 1; i < N; i++) {
				if (flag_down) { // 내려 가는 중인가?
					if (prev == map[i][j]) { // 같을때
						cnt++;
					} else if (prev < map[i][j] && map[i][j] - prev == 1 && cnt >= L) { // 높을때
						prev = map[i][j];
						cnt = 1;
					} else if (prev > map[i][j] && prev - map[i][j] == 1) { // 낮을때
						if (L == 1) {
							flag_down = true;
							cnt = 0;
						} else {
							flag_down = false;
							cnt = 1;
						}
						prev = map[i][j];
					} else { // 길이 안댐
						check_all = false;
						break;
					}
				} else { // 내려가는중
					if (prev == map[i][j]) { // 같음
						cnt++;
						if (cnt == L) { // L만큼 왔음
							flag_down = true;
							cnt = 0;
						}
					} else { // 다름
						check_all = false;
						break;
					}
				}
			}
			
			if (check_all) {
				if (flag_down == false && cnt < L) {

				} else {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

}
