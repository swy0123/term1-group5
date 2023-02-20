package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * swea_4012 [모의 SW 역량테스트] 요리사
 * 
 * @author SSAFY
 *
 */
public class swea_4012 {
	static int[][] table;
	static int N;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			visit = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0,0);
			
		}
	}

	private static void combination(int depth, int start) {
		if(depth == N/2) {
			int value = score(visit);
			return;
		}
		
		if(start >= N/2) {
			return;
		}
		
		for (int i = start; i < N; i++) {
			visit[i] = true;
			combination(depth+1, i+1);
			visit[i] = false;
		}
	}

	private static int score(boolean[] visit) {
		// 2를 골라서 합쳐버려
		int sum1 = sum_score(visit, true);
		int sum2 = sum_score(visit, false);
		
		return 0;
	}

	private static int sum_score(boolean[] visit2, boolean b) {
		// recur
		return 0;
	}

}
