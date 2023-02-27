package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_1043 거짓말 골드 4
 * 
 * @author elder
 *
 */
public class boj_1043 {

	static int N;
	static int M;
	static int[] people;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			people[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int liers = Integer.parseInt(st.nextToken());
		
		// 찐말 들은 사람은 본인(0)과 union
		for (int i = 0; i < liers; i++) {
			int lier = Integer.parseInt(st.nextToken());

			union(0, lier);
		}

		int[][] peoples = new int[M][];
		
		
		// 각 파티 사람들을 리스트로 보관하면서 관계를 union
		for (int i = 0; i < M; i++) {
			boolean flag = false;

			st = new StringTokenizer(br.readLine());
			int peoples_num = Integer.parseInt(st.nextToken());
			peoples[i] = new int[peoples_num];

			for (int j = 0; j < peoples_num; j++) {
				peoples[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < peoples_num - 1; j++) {
				union(peoples[i][j], peoples[i][j + 1]);
			}
		}
		
		// union한 각 파티의 한사람이라도 find() == 0 이면 과장되어 말 못함.
		for (int i = 0; i < M; i++) {
			if (find(people[peoples[i][0]]) != 0) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			if (pa == 0) {
				people[pb] = pa;
			} else if (pb == 0) {
				people[pa] = pb;
			} else {
				people[pa] = pb;
			}
		}

	}

	private static int find(int a) {
		if (people[a] == a)
			return a;
		else
			return people[a] = find(people[a]);
	}

}
