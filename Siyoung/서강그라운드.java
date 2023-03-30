package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서강그라운드 {
	static class node{
		int cur, end, dist;

		public node(int cur, int end, int dist) {
			super();
			this.cur = cur;
			this.end = end;
			this.dist = dist;
		}
	}

	static int n, m, r, res;
	static int[] val;
	static ArrayList<node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		val = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		res = 0;
		
		int from=0, to=0, dist=0;
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			
			arr[from].add(new node(from, to, dist));
			arr[to].add(new node(to, from, dist));
		}
		
//		bfs(1);
		for(int i=1; i<=n; i++) {
			bfs(i);
		}
		System.out.println(res);
	}
	
	private static void bfs(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<node> q = new LinkedList<>();
		boolean[] v = new boolean[n+1];
		dist[0] = 0;
		v[0] = true;
		q.add(new node(0, start, 0));
		int sum = 0;
		while(!q.isEmpty()) {
			node cn = q.poll();
			if(dist[cn.cur]+cn.dist < dist[cn.end] && dist[cn.cur]+cn.dist<=m) {
				if(!v[cn.end]) {
					v[cn.end] = true;
					sum += val[cn.end];
				}
				dist[cn.end] = dist[cn.cur]+cn.dist;
				q.addAll(arr[cn.end]);
			}
		}
//		System.out.println(Arrays.toString(dist));
//		System.out.println(sum);
		res = Math.max(res, sum);
		
	}
}
