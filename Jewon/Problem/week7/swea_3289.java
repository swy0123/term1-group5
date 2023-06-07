package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * swea_3289 서로소 집합 D4
 * 
 * @author elder
 *
 */
public class swea_3289 {

	static int N;
	static int M;
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new int[N + 1];

			for (int i = 0; i < N + 1; i++) {
				list[i] = i;
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (command == 0) {
					union(a, b);
				} else if (command == 1) {
					if (a == b || find(a) == find(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}

			}

			System.out.println();
//			System.out.println(Arrays.toString(list));
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			list[pa] = pb;
		}

	}

	private static int find(int num) {
		if (list[num] == num) {
			return num;
		} else {
			return list[num] = find(list[num]);
		}
	}

}
