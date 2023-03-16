package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 11724 연결 요소의 개수
 */
public class thu_baek_11724 {
	static ArrayList<Integer>[] arr;
	
	static int n, m;
	static boolean[] v;
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
		
		int from, to;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		
		int sum=0;
		for(int i=1; i<=n; i++) {
			if(!v[i]) {
				sum++;
				bfs(i);
			}
			
		}
		System.out.println(sum);
	}
	
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(v[n]) continue;
			v[n] = true;
			
			q.addAll(arr[n]);
		}
	}
	

}
