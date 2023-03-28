package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기2_11779 {
	static class node implements Comparable<node>{
		int end;
		long w;
		public node(int end, long w) {
			super();
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			if(this.w>o.w) return 1;
			else if(this.w==o.w) return 0;
			else return -1;
		}
		@Override
		public String toString() {
			return "node [end=" + end + ", w=" + w + "]";
		}
		
	}
    
    static ArrayList<node>[] arr;
    static int n, m, start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        int from, to, weight;
        L:for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	weight = Integer.parseInt(st.nextToken());
        	arr[from].add(new node(to, weight));
        }
//        for(int i=1; i<=n; i++) {
//        	System.out.println(arr[i]);
//        }System.out.println();
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        long[] dist = new long[n+1];
//        boolean[] v = new boolean[n+1];
        Arrays.fill(dist, n*100000+1);
        ArrayList<Integer>[] root = new ArrayList[n+1];
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));
        dist[start] = 0;
        root[start] = new ArrayList<>();
        root[start].add(start);
        
        while(!pq.isEmpty()) {
        	node cn = pq.poll();
        	if(cn.end==end) break;
//        	if(v[cn.end]) continue;
//        	v[cn.end] = true;
        	
        	for (node next : arr[cn.end]) {
				if(dist[next.end] > dist[cn.end]+next.w) {
					dist[next.end] = dist[cn.end]+next.w;
					root[next.end] = new ArrayList<>();
					root[next.end].addAll(root[cn.end]);
					root[next.end].add(next.end);
					
					pq.add(new node(next.end, dist[next.end]));
				}
			}
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[end]);
        System.out.println(root[end].size());
        StringBuilder sb = new StringBuilder();
        for (Integer tmp : root[end]) {
        	sb.append(tmp+" ");
		}
        System.out.println(sb);
        
    }
}