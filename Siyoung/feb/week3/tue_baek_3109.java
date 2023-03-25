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
	static int[] di = {-1, 0, 1};
	static int[] dj = {1, 1, 1};
	
	static int r, c, map[][], ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		ans = 0;
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c;j++) {
				if(str.charAt(j)=='.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		for (int i = 0; i < r; i++) {
			solve(i, 0);
		}
		
		System.out.println(ans);
	}
	
	private static boolean solve(int i, int j) {
		if(j == c-1) {
			ans++;
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<r && cj>=0 && cj<c && map[ci][cj]==0) {
				map[ci][cj] = 2;
				if(solve(ci, cj)) return true;
			}
			
		}
		return false;
	}

}
