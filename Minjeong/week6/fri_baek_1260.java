import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m, v;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken()) - 1;
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(v, new boolean[n]);
		sb.append("\n");
		bfs(v, new boolean[n]);
		System.out.println(sb.toString());
	}

	private static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		sb.append(v + 1).append(" ");
		
		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);
			if (!visited[next]) dfs(next, visited);
		}
	}

	private static void bfs(int v, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[v] = true;
		q.offer(v);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + 1).append(" ");
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}