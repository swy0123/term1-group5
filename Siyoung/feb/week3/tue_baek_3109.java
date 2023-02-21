package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 3109 빵집
 */
public class tue_baek_3109 {
	static class point{
		int i, j;
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	static int[] di = {-1, 0, 1};
	static int[] dj = {1, 1, 1};
	
	static int r, c, map[][], ans;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		int res = 0;
		ans = 0;
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c;j++) {
				if(str.charAt(j)=='.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
//		for (int[] t : map) {
//			System.out.println(Arrays.toString(t));
//		}
		
		for (int i = 0; i < r; i++) {
			flag=false;
			solve(i, 0);
		}
		
		System.out.println(ans);
	}
	
	private static void solve(int i, int j) {
		//속도향상
		if(flag) return;
		
		// cnt-> c까지
		if(j == c-1) {
			ans++;
			flag = true;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<r && cj>=0 && cj<c && map[ci][cj]==0 && !flag) {
				map[ci][cj] = 2;
				solve(ci, cj);
			}
			
		}
		
	}

}
