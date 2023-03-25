package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 13905 세부
 */
public class wed_baek_13905 {

	static class node implements Comparable<node>{
		int end, weight;

		public node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}		

		@Override
		public int compareTo(node o) {
			return o.weight - this.weight;
		}
	}
	
	static ArrayList<node>[] arr;
	static int n, m, s, e;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		v = new boolean[n+1];
		
		arr = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int from, to, weight;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			arr[from].add(new node(to, weight));
			arr[to].add(new node(from, weight));
		}

		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.addAll(arr[s]);
		v[s] = true;
		
		int min = Integer.MAX_VALUE;
		while(!pq.isEmpty()) {
			node cur = pq.poll();

			if(v[cur.end]) continue;
			else v[cur.end] = true;
			
			min = Math.min(min, cur.weight);
			
			if(cur.end == e) {
				break;
			}
			pq.addAll(arr[cur.end]);
			
		}
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
		
	}
}
