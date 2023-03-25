package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * swea_3124 최소 스패닝 트리 D4
 * 
 * @author SSAFY
 *
 */
public class swea_3124 {

	static int V;
	static int E;

	static class Edge implements Comparable<Edge> {

		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}

	static int[] parents;
	static PriorityQueue<Edge> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			q = new PriorityQueue<>();
			// make - set
			parents = new int[V + 1];
			for (int i = 0; i < V + 1; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				q.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			int size = q.size();
			int cnt = 0;
			long sum = 0;

			for (int i = 0; i < size; i++) {
				Edge e = q.poll();

				if (union(e.start, e.end)) {
					sum += e.weight;
					if (++cnt == V - 1) {
						break;
					}
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}

	private static boolean union(int start, int end) {
		int pa = find(start);
		int pb = find(end);

		if (pa != pb) {
			parents[pa] = pb;
			return true;
		} else {
			return false;
		}
	}

	private static int find(int start) {
		if (parents[start] == start)
			return start;
		else
			return parents[start] = find(parents[start]);
	}

}
