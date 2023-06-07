package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고스탁 {
	
	static int start, add, n, l, sum, cmax;
	static int[][] map;
	static int[][] w;
	static int[] max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			add = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][l+1];
			w = new int[n][l+1];
			max = new int[l];
			
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<=l; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(j>0) {
						w[i][j-1] = map[i][j]-map[i][j-1];
					}
				}
			}
			
			sum = 0;
			solve(0, start);
			System.out.println("#"+test_case+" "+(max[l-1]-(start+add*(l))));
		}
		
	}
	
	private static void solve(int month, int money) {
		if(month == l) {
			sum = money;
			return;
		}
		cmax = 0;
		if(month < l) {
			mon(0, money, month, new int[n]);
			money += cmax;
		}
		money += add;
		max[month] = money;
		solve(month+1, money);
		
	}
	
	//마지막 전 주까지
	private static void mon(int idx, int money, int month, int[] v) {
		int tmp = money;
		if(idx == v.length) {
			int curSum = 0;
			for(int i=0; i<v.length; i++) {
				curSum += w[i][month] * v[i];
			}
			cmax = Math.max(cmax, curSum);
			return;
		}
		
		if(w[idx][month] > 0) {
			if(tmp > map[idx][month]) {
				v[idx] += 1;
				mon(idx, tmp-map[idx][month], month, v);
				v[idx] -= 1;
			}
		}
		mon(idx+1, tmp, month, v);
	}

}
