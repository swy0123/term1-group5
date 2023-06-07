package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int[][] map;
	static int d, w, k, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[d][w];
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<k; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = Integer.MAX_VALUE;
			solve(0, new boolean[d]);
			
			
			
			System.out.println("#"+tc+" "+res);
			
		}
	}
	
	//1~두께 조합
	private static void solve(int idx, boolean[] v) {
		if(idx==d) {
			res = Math.min(res, idx);
			return;
		}
		if(passCheck(v)) {
			res = Math.min(res, idx);
			return;
		}
		
		v[idx] = true;
		solve(idx+1, v);
		v[idx] = false;
		solve(idx+1, v);
		
		
	}

	// 합격 체크
	private static boolean passCheck(boolean[] v) {
		
		boolean pass = true;
		for(int j=0; j<w; j++) {
			int cnt = 1;
			boolean check = false;
			for(int i=0; i<d-1; i++) {
				if(map[i][j]==map[i+1][j]) {
					cnt++;
				}
				if(cnt == k) {
					check = true;
					continue;
				}
				else {
					cnt = 1;
				}
			}
			if(!check) {
				pass = false;
				break;
			}
		}
		
		return pass;
	}
	
	
}