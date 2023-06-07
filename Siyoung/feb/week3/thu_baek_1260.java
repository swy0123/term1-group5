package feb.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 1260 dfs와 bfs
 */
public class thu_baek_1260 {
	static ArrayList<Integer>[] adjList;
	static int n, m, v;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adjList= new ArrayList[n+1];
		for(int i=0; i<n+1; ++i) {
			adjList[i] = new ArrayList<Integer>();
		}
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			adjList[r].add(d);
			adjList[d].add(r);
			
		}
//		for (ArrayList<Integer> ii : adjList) {
//			System.out.println(ii);
//		}
		
		dfs(v);
		System.out.println();
		bfs(v);
	}
	
	private static void dfs(int num) {
		if(visited[num]) {
			return;
		}
		System.out.print(num+" ");
		visited[num] = true;
		
		int[] tmp = new int[adjList[num].size()];
		
		for(int i=0; i<adjList[num].size(); i++) {
			tmp[i] = adjList[num].get(i);
		}
		Arrays.sort(tmp);
		
		for (int i : tmp) {
			if(!visited[i]) dfs(i);
		}
		
	}
	
	private static void bfs(int num) {
		visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int c = q.poll();
			System.out.print(c+" ");
			
			int[] tmp = new int[adjList[c].size()];
			
			for(int i=0; i<adjList[c].size(); i++) {
				tmp[i] = adjList[c].get(i);
			}
			Arrays.sort(tmp);
			
			for (int i : tmp) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
		
	}

}
