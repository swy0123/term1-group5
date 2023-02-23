package algorithm.week3.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class thu_baek_1260 {
	static ArrayList<Integer>[] adjList;
	static int n, m, v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adjList= new ArrayList[m];
		for(int i=0; i<m; ++i) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			adjList[r].add(d);
		}
		for (ArrayList<Integer> ii : adjList) {
			System.out.println(ii);
		}
		
//		dfs(adjList);
		
	}
	
	private static void dfs(ArrayList<Integer>[] arr) {
		System.out.println();
		Stack<ArrayList<Integer>> s = new Stack<>();
		s.add(arr[v]);
		
		while(!s.isEmpty()) {
			
			
			
		}
		
	}

}
