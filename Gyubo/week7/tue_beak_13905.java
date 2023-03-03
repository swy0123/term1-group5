import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 세부
public class tue_beak_13905 {

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}

	private static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int currentPos = Integer.parseInt(st.nextToken());
		int targetPos = Integer.parseInt(st.nextToken());

		Map<Integer, List<Node>> map = new HashMap<>();

		for (int i = 0; i < n + 1; i++) {
			map.put(i, new ArrayList<Node>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map.get(node1).add(new Node(node1, node2, cost));
			map.get(node2).add(new Node(node2, node1, cost));
		}

		int[] dist = new int[n + 1];
		int[] parent = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.addAll(map.get(currentPos));

		int count = 1;
		visited[currentPos] = true;

		while (count < n && !q.isEmpty()) {
			Node p = q.poll();
			if (visited[p.to]) {
				continue;
			}
			dist[p.to] = p.cost;
			parent[p.to] = p.from;
			count++;
			visited[p.to] = true;
			q.addAll(map.get(p.to));
		}
		if (parent[targetPos] == targetPos) {
			System.out.println(0);
			return;
		}
		System.out.println(findParent(parent, dist, targetPos));
	}

	private static int findParent(int[] parent, int[] dist, int targetPos) {
		if (parent[targetPos] == targetPos) {
			return Integer.MAX_VALUE;
		} else {
			return Math.min(dist[targetPos], findParent(parent, dist, parent[targetPos]));
		}
	}
}
