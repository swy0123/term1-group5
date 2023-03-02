import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백도어
public class thu_beak_17396 {

	static class Vertex implements Comparable<Vertex> {

		int e;
		long cost;
		;

		public Vertex(int e, long cost) {
			super();
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Vertex [e=" + e + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			long d = this.cost - o.cost;
			if (d > 0) {
				return 1;
			} else if (d < 0) {
				return -1;
			} else {
				return 0;
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] info = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		info[n - 1] = 0;

		Map<Integer, List<Vertex>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (info[num1] == 1 || info[num2] == 1) {
				continue;
			}

			graph.get(num1).add(new Vertex(num2, cost));
			graph.get(num2).add(new Vertex(num1, cost));
		}

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(new Vertex(0, 0));
		boolean[] visited = new boolean[n];

		while (!q.isEmpty()) {
			Vertex current = q.poll();
			if (visited[current.e]) {
				continue;
			}
			visited[current.e] = true;

			List<Vertex> nexts = graph.get(current.e);
			for (Vertex next : nexts) {
				if (dist[next.e] > dist[current.e] + next.cost) {
					dist[next.e] = dist[current.e] + next.cost;
					q.add(new Vertex(next.e, dist[next.e]));
				}
			}
		}

		System.out.println(dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1]);
	}
}
