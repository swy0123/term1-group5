package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_5656 [모의 SW 역량테스트] 벽돌 깨기
 * 
 * @author SSAFY
 *
 */
public class boj_5656 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, W, H;
	static List<Integer>[] map;
	static int Ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new ArrayList[W];
			for (int i = 0; i < W; i++) {
				map[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp != 0) {
						map[j].add(temp);
					}
				}
			}

//			print();
			arr = new int[N];
			combination(0);

			System.out.println("#" + test_case + " " + Ans);
		}

	}

	static int[] arr;
	static List<Integer>[] map_copy;

	private static void combination(int depth) {
		if (depth == N) {
			// 중복 순열을 뽑음

			// map_copy
			map_copy = new ArrayList[W];
			for (int i = 0; i < W; i++) {
				map_copy[i] = new ArrayList<Integer>(map[i]);
			}

			for (int i = 0; i < arr.length; i++) {
				// 만약 떨어진 곳이 아무런 벽돌도 없다면
				if (map_copy[arr[i]].size() == 0) {
					continue;
				} else {
					// col 의 row를 터트림
					boom(map_copy[arr[i]].size(), arr[i]);
				}

				clean();
			}

			// 남은 벽돌 수 세기
			int sum = 0;
			for (int i = 0; i < map_copy.length; i++) {
				sum += map_copy[i].size();
			}

			Ans = Math.min(Ans, sum);
			return;
		}

		for (int i = 0; i < W; i++) {
			arr[depth] = i;
			combination(depth + 1);
		}

	}

	private static void clean() {
		for (int i = 0; i < map_copy.length; i++) {
			for (int j = 0; j < map_copy[i].size(); j++) {
				if (map_copy[i].get(j) == 0) {
					map_copy[i].remove(j);
					j--;
				}
			}
		}
	}

	private static void boom(int height, int drop_col) {
		
		// 해당 col 아무 벽돌이 없으면 스킵
		if (map_copy[drop_col].size() == 0 || map_copy[drop_col].size() < row) {
			return;
		}
		
		int targetIdx = map_copy[drop_col].size() - height;
		
		int temp = map_copy[drop_col].get(r_row);

		if (temp == 1) {
			map_copy[drop_col].set(r_row, 0);
		} else if (temp > 1) {
			map_copy[drop_col].set(r_row, 0);
			for (int i = 1; i < temp; i++) { // range
				for (int j = 0; j < dir.length; j++) {
					int nr = r_row + dir[j][0] * i;
					int nc = drop_col + dir[j][1] * i;

					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						boom(nr, nc);
					}
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i].toArray()));
		}

	}

}
