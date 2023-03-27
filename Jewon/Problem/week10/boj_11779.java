import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11779 {

	static class Node {
		int num;
		Node next;
		Node prev;

		public Node(int num, Node next, Node prev) {
			super();
			this.num = num;
			this.next = next;
			this.prev = prev;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", next=" + next + ", prev=" + prev + "]";
		}

	}

	static class Vertex implements Comparable<Vertex> {
		int end, weight;

		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static List<Vertex>[] adjList;
	static int N, M;
	static boolean[] visit;
	static int start, end;

	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static Node[] nodes;
	static int[] route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		adjList = new List[N];
		dist = new int[N];
		route = new int[N];
		Arrays.fill(dist, INF);

		nodes = new Node[N];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i, null, null);
		}

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		visit = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Vertex(b, c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(new Vertex(start, 0));
		Arrays.fill(route, -1);
		route[start] = -1;

		dist[start] = 0;

//		visit[start] = true;

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visit[v.end]) {
				continue;
			}

			visit[v.end] = true;

			for (Vertex next : adjList[v.end]) {
				if (!visit[next.end] && dist[next.end] > dist[v.end] + next.weight) {
					dist[next.end] = dist[v.end] + next.weight;
					q.offer(new Vertex(next.end, dist[v.end] + next.weight));
					route[next.end] = v.end;
				}
			}
		}
//		System.out.println(Arrays.toString(route));
//		System.out.println(Arrays.toString(dist));
		List<Integer> routes = new ArrayList<>();
		int current = end;

		while (current != -1) {
			routes.add(current);
			current = route[current];
		}

		System.out.println(dist[end]);
		System.out.println(routes.size());
		for (int i = 0; i < routes.size(); i++) {
			System.out.print((routes.get(routes.size() - 1 - i) + 1) + " ");
		}
	}

}
