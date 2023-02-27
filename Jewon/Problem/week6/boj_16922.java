package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_16922 로마 숫자 만들기 실버 3
 * 
 * @author elder
 *
 */

public class boj_16922 {
	static int[] list = { 1, 5, 10, 50 };
	static int N;
	static int cnt = 0;
	static boolean[] check = new boolean[1000 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		dfs(0, 0, 0);

		System.out.println(cnt);
	}

	private static void dfs(int depth, int start, int sum) {

		if (depth == N && !check[sum]) {
			check[sum] = true;
			cnt++;
			return;
		}
		
		if(depth == N) {
			return;
		}

		for (int i = start; i < list.length; i++) {
			dfs(depth + 1, i, sum + list[i]);
		}
	}
}
