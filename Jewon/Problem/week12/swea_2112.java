package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * 2112. [모의 SW 역량테스트] 보호 필름
 * 
 */
public class swea_2112 {

	static int D, W, K;
	static int[][] map;
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			list = new int[D];
			dfs(0, 0);
			
			System.out.println("#"+test_case + " " + Ans);
		}
	}

	static int[] list; // 0 - A 1 - B 2 - X

	private static void dfs(int depth, int cnt) {
		if(cnt >= Ans) {
			return;
		}
		
		if (depth == D) {
//			System.out.println(Arrays.toString(list));
			if (check()) {
				Ans = Math.min(Ans, cnt);
//				System.out.println(cnt);
//				System.out.println(Arrays.toString(list));
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			list[depth] = i;
			if (i == 2) {
				dfs(depth + 1, cnt);
			} else {
				dfs(depth + 1, cnt+1);
			}
		}
	}

	private static boolean check() {
		int current = -1;
		int cur_cnt = 0;
		outer : for (int col = 0; col < W; col++) {
			cur_cnt = 1;

			if (list[0] == 0) {
				current = 0;
			}

			if (list[0] == 1) {
				current = 1;
			}

			if (list[0] == 2) {
				current = map[0][col];
			}
			
			for (int row = 1; row < D; row++) {
				int next = map[row][col];
				
				if (list[row] == 0) {
					next = 0;
				}

				if (list[row] == 1) {
					next = 1;
				}
				
				// 뒤랑 같은가 다른가
				if(current == next) {
					cur_cnt++;
				}else {
					current = next;
					cur_cnt = 1;
				}
				
				if(cur_cnt >= K) {
					continue outer;
				}
			}
			
			return false;
		}
		return true;
	}

}
