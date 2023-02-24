package algorithm.week3.fri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * swea 7465. 창용 마을 무리의 개수
 */
public class fri_swea_7465 {

	static ArrayList<Integer>[] arr;
	static int n, m, cnt;
	static boolean[] v;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[n];
			v = new boolean[n];
			cnt = 0;
			
			for(int i=0; i<n; ++i) {
				arr[i] = new ArrayList<Integer>();
			}
			
			int from, to;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken())-1;
				to = Integer.parseInt(st.nextToken())-1;

				arr[from].add(to);
				arr[to].add(from);
			}
			
			for (int i=0; i<n; i++) {
				if(!v[i]) {
					cnt++;
					dfs(i);
				}
			}
			System.out.println("#"+test_case+" "+ cnt);
//			System.out.println(Arrays.toString(v));
		
		}
	}
	
	private static void dfs(int cur) {
		v[cur] = true;
		
		for (int next : arr[cur]) {
			if(!v[next]) {
				dfs(next);
			}
		}
	}

}
