package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.RecursiveAction;

/**
 * boj_3109 빵집 골드2
 * 
 * @author SSAFY
 *
 */
public class boj_3109 {
	
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int R;
	static int C;
	static Character[][] map;
	static int ans = 0;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new Character[R][C];

		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = sb.charAt(j);
			}
		}
		
		for (int r = 0; r < R; r++) {
			flag = false;
			Recursive(r, 0);

		}
		
		System.out.println(ans);
	}

	private static void Recursive(int r, int c) {	
		if(flag) {
			return;
		}
		
		//basis part
		if(c == C-1) {
			ans++;
			flag = true;
			return;
		}
		
		//inductive part
		for (int i = 0; i < dir.length; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr >= 0 && nr < R && nc >=0 && nc< C && map[nr][nc] == '.' && !flag){
				map[nr][nc] = 'x';
				Recursive(nr,nc);
			}
		}
	}
	
	

}