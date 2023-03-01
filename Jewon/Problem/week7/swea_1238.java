package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * swea_1238 Contact D4
 * 
 * @author elder
 *
 */
public class swea_1238 {

	static List<Integer>[] list;
	static int startIdx;
	static int N = 100;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 데이터의 길이와 시작점
			int length = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			dist = new int[N + 1];
			Arrays.fill(dist, -1);

			for (int i = 1; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			startIdx = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
			}

			bfs(startIdx);
			int maxIdx = 0;
			int maxValue = Integer.MIN_VALUE;

			for (int i = 1; i < N + 1; i++) {
				if (maxValue <= dist[i]) {
					maxIdx = i;
					maxValue = dist[i];
				}
			}
			
			System.out.println("#" + test_case + " " + maxIdx);
//			System.out.println(Arrays.toString(dist));

		}

	}

	private static void bfs(int startIdx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(startIdx);
		dist[startIdx] = 0;
		int level = 1;
		int size = 0;

		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				int temp = q.poll();

				for (int next : list[temp]) {
					if (dist[next] == -1) {
						dist[next] = level;
						q.offer(next);
					}
				}

			}
			level++;
		}

	}

}
