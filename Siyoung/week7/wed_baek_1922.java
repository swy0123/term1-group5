package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 1922 네트워크 연결
 */
public class wed_baek_1922 {
	
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
	static ArrayList<node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int from, to, w;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, w));
			arr[to].add(new node(from, w));
		}
		
		int sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[n+1];
		v[1] = true;
		pq.addAll(arr[1]);
		
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(v[cn.end]) continue;
			v[cn.end] = true;
			sum+=cn.weight;
			pq.addAll(arr[cn.end]);
			
		}
		
		System.out.println(sum);
	}

}
