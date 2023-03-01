package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 1647 도시 분할 계획
 */
public class wed_baek_1647 {
	
	static class node implements Comparable<node>{
		int end, weight;
		
		public node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(node o) {
			return this.weight - o.weight;
		}
	}
	
	static int n, m;
	static boolean[] v;
	static ArrayList<node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		v = new boolean[n+1];
		
		int from = 0, to, weight;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, weight));
			arr[to].add(new node(from, weight));
		}

		int max = 0, sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.addAll(arr[from]);
		v[from] = true;
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(v[cn.end]) continue;
			else v[cn.end] = true;
			max = Math.max(cn.weight, max);
			sum += cn.weight;
			
			pq.addAll(arr[cn.end]);
		}
		
		System.out.println(sum-max);
		
	}
	
	

}
