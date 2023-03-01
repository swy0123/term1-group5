package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 4386 별자리 만들기
 */
public class wed_baek_4386 {
	
	static class point{
		int i, j;
		
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	static class node implements Comparable<node>{
		int end, weight;

		public node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

//		@Override
//		public String toString() {
//			return "node [end=" + end + ", weight=" + weight + "]";
//		}

		@Override
		public int compareTo(node o) {
			return this.weight - o.weight;
		}
	}
	
	static int n;
	static boolean[] v;
	static ArrayList<point> arr;
	static ArrayList<node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		graph = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		v = new boolean[n+1];
		
		int i, j;
		for(int c=1; c<=n; c++) {
			st = new StringTokenizer(br.readLine());
			i = (int) (Float.parseFloat(st.nextToken())*100);
			j = (int) (Float.parseFloat(st.nextToken())*100);
			arr.add(new point(i, j));
		}
		
		for (int k=1; k<=n; k++) {
			for(int l=1; l<=n; l++) {
				if(k==l) continue;
				graph[k].add(new node(l, dist(arr.get(k-1), arr.get(l-1))));
			}
		}
//		for (ArrayList<node> is : graph) {
//			System.out.println(is);
//		}
		
		float sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		v[1] = true;
		pq.addAll(graph[1]);
		
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(v[cn.end]) continue;
			v[cn.end] = true;
			sum+=cn.weight;
			pq.addAll(graph[cn.end]);
			
		}
		float res = sum / 100;
		System.out.printf("%.2f", res);
		
	}
	
	private static int dist(point p1, point p2) {
		return (int) Math.sqrt((Math.pow(Math.abs(p1.i-p2.i), 2) + Math.pow(Math.abs(p1.j-p2.j), 2)));
	}

}
