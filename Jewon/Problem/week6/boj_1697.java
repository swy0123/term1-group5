package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1697 숨바꼭질 실버 1
 * 
 * @author SSAFY
 *
 */
public class boj_1697 {
	static int[] map = new int[100_001];
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map[N] = N;
		map[M] = M;

		bfs(N);
	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);

		int size;
		int level = 0;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				int num = q.poll();

				// x-1
				if (num - 1 >= 0 && map[num - 1] != N) {

				}

				// x+1
				if (map[num +1] != N) {

				}

				// x*2
				if (map[num * 2] != N) {

					

			}
		}
	}

}
