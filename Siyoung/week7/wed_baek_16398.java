package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 16398 행성 연결
 */
public class wed_baek_16398 {
	
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
	
	static int n;
	static boolean[] v;
	static ArrayList<node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();				
		}
		v = new boolean[n+1];
		
		int w = 0;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				w = Integer.parseInt(st.nextToken());
				arr[i].add(new node(j, w));
			}
		}
		
		long sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.addAll(arr[1]);
		v[1] = true;
		
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(v[cn.end]) continue;
			v[cn.end] = true;
			sum += cn.weight;
			
			pq.addAll(arr[cn.end]);
		}
		
		System.out.println(sum);
	}

}
