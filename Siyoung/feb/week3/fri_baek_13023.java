package algorithm.week3.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 13023 ABCDE
 */
public class fri_baek_13023 {
	
	static ArrayList<Integer>[] arr;
	static int n, m, cnt;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int a, b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=0; i<n; i++) {
			boolean[] v = new boolean[n];
			v[i] = true;
			dfs(i, 0, v);
			if(flag) break;
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
		
//		if(flag) System.out.println(1);
//		else System.out.println(0);

	}
	
	
	private static void dfs(int cur, int cnt, boolean[] v) {
		if(flag) return;
		if(cnt == 4) {
			flag = true;
		}
		
		for (int tmp : arr[cur]) {
			if(!v[tmp]) {
				v[cur] = true;
				dfs(tmp, cnt+1, v);
				v[cur] = false;
			}
		}
	}

}
