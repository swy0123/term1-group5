package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * boj_16234 인구 이동 골드5
 * 
 * @author SSAFY
 *
 */

//union find
public class boj_16234 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int L;
	static int R;
	static int[] city;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// make-set
		int level = 0;
		while (true) {
			makeset();
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// map[i][j]
					for (int d = 0; d < dir.length; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							int diff = Math.abs(map[i][j] - map[nr][nc]);
							if (diff >= L && diff <= R) {
								if (union(i * N + j, nr * N + nc)) {
									// 인구 합치기
								}
								flag = true;
							}
						}
					}
				}
			}

			if (!flag) {
				break;
			}

			// 그룹 인구를 더하고 나누기 <root , [cnt , sum]>
			HashMap<Integer, Integer[]> map_list = new HashMap<Integer, Integer[]>();
			for (int i = 0; i < city.length; i++) {
				if (!map_list.containsKey(find(city[i]))) {
					Integer[] temp = new Integer[] { 1, map[i / N][i % N] };
					map_list.put(find(city[i]), temp);
				} else {
					Integer[] temp = map_list.get(find(city[i]));
					temp[0]++;
					temp[1] += map[i / N][i % N];
					map_list.put(find(city[i]), temp);
				}
			}

			Iterator<Integer> keys = map_list.keySet().iterator();

			for (int i = 0; i < map_list.size(); i++) {
				int key = keys.next();
				Integer[] temp = map_list.get(key);
				if (temp[0] > 1) {
					int value = temp[1] / temp[0];
					for (int j = 0; j < city.length; j++) {
						if (find(city[j]) == key) {
							map[j / N][j % N] = value;
						}
					}
				}
			}
			level++;
		}
		System.out.println(level);

	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			city[pb] = pa;
			return true;
		} else {
			return false;
		}

	}

	private static int find(int a) {
		if (city[a] == a)
			return a;
		else
			return city[a] = find(city[a]);
	}

	private static void makeset() {
		city = new int[N * N];
		for (int i = 0; i < N * N; i++) {
			city[i] = i;
		}
	}

}
