package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * swea 2115. [모의 SW 역량테스트] 벌꿀채취
 */
public class sat_swea_2115 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, m, c, max, cmax, map[][];
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			v = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			solve(0, new int[2]);
			System.out.println("#"+test_case+" "+max);
		}

	}
	
	private static void solve(int idx, int[] visited) {
		if(idx == 2) {
			int sum = 0;
			for (int i : visited) {
				sum+=i;
			}
//			if(max < sum) {
//				System.out.println(sum +" "+Arrays.toString(visited));
//				max = sum;
//			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			L:for(int j=0; j<n-m+1; j++) {
				for(int cnt=0; cnt<m; cnt++) {
					if(v[i][j+cnt]) {
						continue L;
					}
				}
				int[] tmp = new int[m];
				for(int cnt=0; cnt<m; cnt++) {
					v[i][j+cnt] = true;
					tmp[cnt] = map[i][j+cnt];
				}
				cmax = 0;
				count(0, 0, tmp, new boolean[n]);
				visited[idx] = cmax;
				solve(idx+1, visited);
				for(int cnt=0; cnt<m; cnt++) {
					v[i][j+cnt] = false;
				}
			}
		}
		
	}
	
	private static void count(int idx, int weight, int[] tmp, boolean[] visited) {
		if(weight > c) return;
		if(idx == m) {
			int sum = 0;
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					sum+=tmp[i]*tmp[i];
				}
			}
//			if(cmax < sum) {
//				System.out.println(sum +" "+Arrays.toString(tmp));
//				cmax = sum;
//			}
			cmax = Math.max(cmax, sum);
			return;
		}
		
		visited[idx] = true;
		count(idx+1, weight+tmp[idx], tmp, visited);
		visited[idx] = false;
		count(idx+1, weight, tmp, visited);
			
	}

}
