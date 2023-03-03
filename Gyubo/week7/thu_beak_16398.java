import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 행성 연결
public class thu_beak_16398 {

	static class Vertex implements Comparable<Vertex> {
		int e;
		int cost;

		public Vertex(int e, int cost) {
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
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Map<Integer, List<Vertex>> graph = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Vertex> tmpList = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (cost == 0) {
					continue;
				}
				tmpList.add(new Vertex(j, cost));
			}
			graph.put(i, tmpList);
		}

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		q.addAll(graph.get(0));
		visited[0] = true;

		long sum = 0;
		int cnt = 0;

		while (!q.isEmpty() && cnt < n - 1) {
			Vertex p = q.poll();
			if (visited[p.e]) {
				continue;
			}

			visited[p.e] = true;
			cnt++;
			sum += p.cost;
			q.addAll(graph.get(p.e));
		}
		
		System.out.println(sum);
	}
}
