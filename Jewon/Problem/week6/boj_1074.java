package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_1074 Z 실버1
 * 
 * @author SSAFY
 *
 */
public class boj_1074 {
	static int N;
	static int r;
	static int c;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		cut(r, c, (int) Math.pow(2, N));
	}

	private static void cut(int row, int col, int size) {
		int half = size / 2;

		int temp_row = row / half;
		int temp_col = col / half;

		cnt += (temp_row * 2 * (half * half));
		cnt += (temp_col * half * half);
		
		if(half == 1) {
			System.out.println(cnt);
			return;
		}
		
		cut(row - (temp_row * half), col - (temp_col * half), half);

	}

}
