package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1260 DFS와 BFS 실버 2
 * 
 * @author SSAFY
 *
 */
public class boj_1260 {

	static List<Integer>[] adjList;
	static int N;
	static int start;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(adjList[i]);
		}
		
//		print();

		visit = new boolean[N + 1];
		System.out.print(start + " ");
		visit[start] = true;
		dfs(start);
	
		System.out.println();
		visit = new boolean[N+1];
		bfs(start);

	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < adjList.length; i++) {
			System.out.println(Arrays.toString(adjList[i].toArray()));
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			System.out.print(vertex + " ");
			
			for (int i = 0; i < adjList[vertex].size(); i++) {
				if(visit[adjList[vertex].get(i)] == false) {
					visit[adjList[vertex].get(i)] = true;
					q.offer(adjList[vertex].get(i));
				}
			}
		}
	}

	private static void dfs(int start) {

		for (int i = 0; i < adjList[start].size(); i++) {
			if (visit[adjList[start].get(i)] == false) {
				visit[adjList[start].get(i)] = true;
				System.out.print(adjList[start].get(i) + " ");
				dfs(adjList[start].get(i));
			}
		}

	}

}
