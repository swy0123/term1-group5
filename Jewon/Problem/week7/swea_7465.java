package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * swea_7465 창용 마을 무리의 개수 D4
 * 
 * @author elder
 *
 */

public class swea_7465 {

	static int N;
	static int M;
	static int[] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			friends = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				friends[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			int cnt = 0;
			
			for (int i = 1; i < N + 1; i++) {
				if (friends[i] == i) {
					cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);

		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			friends[pa] = pb;
		}
	}

	private static int find(int a) {
		if (friends[a] == a)
			return a;
		else
			return friends[a] = find(friends[a]);
	}

}
