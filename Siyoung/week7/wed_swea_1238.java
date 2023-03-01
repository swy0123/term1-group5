package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 1238. [S/W 문제해결 기본] 10일차 - Contact
 */
public class wed_swea_1238
{
	static class node{
		int num, cnt;

		public node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	
	static ArrayList<Integer>[] arr;
	static int n, max, mcnt;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[101];
			
			for(int i=1; i<=100; i++) {
				arr[i] = new ArrayList<>();
			}
			
			int from, to;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
			}
			max = 0;
			mcnt = 0;
			
			bfs(start);
			
			System.out.println("#"+test_case+" "+ max);
		
		}
	}
	
	private static void bfs(int num) {
		Queue<node> q = new LinkedList<>();
		boolean[] v = new boolean[101];
		q.add(new node(num, 0));
		v[num] = true;
		
		while(!q.isEmpty()) {
			node nd = q.poll();
			
			
			for (int c : arr[nd.num]) {
				if(!v[c]) {
					q.add(new node(c, nd.cnt+1));
					v[c] = true;
					if(nd.cnt+1>mcnt) {
						max = c;
						mcnt = nd.cnt+1;
					}
					else if(nd.cnt+1==mcnt){
						max = Math.max(max, c);
					}
//					System.out.println(max+ " "+nd.cnt+1);
				}
				
			}
		}
		
		
	}
	
}