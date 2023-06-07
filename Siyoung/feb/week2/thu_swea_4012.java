package algorithm.tmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * swea 4012. [모의 SW 역량테스트] 요리사
 */
public class thu_swea_4012 {
	static int n, min;

	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			boolean[] v = new boolean[n];
			v[0] = true;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			per(map, v, 1, 1);
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	
	private static void per(int[][] map, boolean[] v, int idx, int cnt) {
		if(cnt == n/2) {
			int sum1 = 0, sum2 = 0;
			for(int i=0; i<v.length-1; i++) {
				if(v[i]) {
					for(int j=i; j<v.length; j++) {
						if(v[j]) {
							sum1 += map[i][j]+map[j][i];
//							System.out.println(sum1);
						}
					}
				}
				else {
					for(int j=i; j<v.length; j++) {
						if(!v[j]) {
							sum2 += map[i][j]+map[j][i];
//							System.out.println(sum2);
						}
					}
				}
			}
//			if(min>Math.abs(sum1-sum2)) {
//				System.out.println(Arrays.toString(v));
//			}
			min = Math.min(min, Math.abs(sum1-sum2));
			
			
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if(v[i] !=true) {
				v[i] = true;
				per(map, v, i+1, cnt+1);
				v[i] = false;
			}
			
		}
		
		
		
	}

}
