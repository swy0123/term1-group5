package algorithm.week3.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 1987 알파벳
 * swea 수지의 수지맞은 여행과 동일
 */
public class thu_baek_1987 {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	static int r, c, max;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		max = 0;
		map = new char[r][c];
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean[] v = new boolean[26];
		v[map[0][0]-'A'] = true;
		solve(0, 0, v, 1);
		
		System.out.println(max);

	}
	
	private static void solve(int i, int j, boolean[] v, int cnt) {
		max = Math.max(max, cnt);
		
		for(int d=0; d<4; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<r && cj>=0 && cj<c && !v[map[ci][cj]-'A']) {
				v[map[ci][cj]-'A'] = true;
				solve(ci, cj, v, cnt+1);
				v[map[ci][cj]-'A'] = false;
			}
		}
	}

}
