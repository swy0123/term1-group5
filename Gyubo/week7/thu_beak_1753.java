import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단 경로
public class thu_beak_1753 {

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
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(br.readLine());

		Map<Integer, List<Vertex>> graph = new HashMap<>();

		for (int i = 1; i < v + 1; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] dist = new int[v + 1];

		for (int i = 1; i < v + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Q 사용	
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(new Vertex(startNode, 0));
		dist[startNode] = 0;

		while (!q.isEmpty()) {
			Vertex current = q.poll();
			
			List<Vertex> nexts = graph.get(current.e);
			for (Vertex next : nexts) {
				if (dist[next.e] > dist[current.e] + next.cost) {
					dist[next.e] = dist[current.e] + next.cost;
					q.add(new Vertex(next.e, dist[next.e]));
				}
			}
		}

		// Q 미사용
//		dist[startNode] = 0;
//		for (int i = 0; i < v - 1; i++) {
//			// 가장 작은 값 찾기
//			int minValue = Integer.MAX_VALUE;
//			int minIndex = -1;
//			for (int j = 1; j < dist.length; j++) {
//				if (!visited[j] && minValue > dist[j]) {
//					minIndex = j;
//					minValue = dist[j];
//				}
//			}
//
//			if (minIndex == -1) {
//				break;
//			}
//
//			visited[minIndex] = true;
//			List<Vertex> nexts = graph.get(minIndex);
//			for (Vertex vertex : nexts) {
//				if (dist[vertex.e] > vertex.cost + dist[minIndex]) {
//					dist[vertex.e] = vertex.cost + dist[minIndex];
//				}
//			}
//		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}
}
