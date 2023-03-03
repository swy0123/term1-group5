import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class tue_beak_1197 {

	static class Vertex implements Comparable<Vertex> {
		int nextNode;
		int cost;

		public Vertex(int nextNode, int cost) {
			super();
			this.nextNode = nextNode;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Vertex [nextNode=" + nextNode + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[v + 1];
		int[] dist = new int[v + 1];
		HashMap<Integer, ArrayList<Vertex>> map = new HashMap<Integer, ArrayList<Vertex>>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map.putIfAbsent(node1, new ArrayList<Vertex>());
			map.putIfAbsent(node2, new ArrayList<Vertex>());
			map.get(node1).add(new Vertex(node2, cost));
			map.get(node2).add(new Vertex(node1, cost));
		}

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.addAll(map.get(1));

		visited[1] = true;
		int sum = 0;
		int cnt = 1;
		while (cnt < v) {
			Vertex p = q.poll();
			if (visited[p.nextNode]) {
				continue;
			}
			visited[p.nextNode] = true;
			dist[p.nextNode] = p.cost;
			cnt++;
			sum += p.cost;
			q.addAll(map.get(p.nextNode));
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(sum);
	}
}
