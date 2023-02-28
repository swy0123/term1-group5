package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_17471 게리맨더링 골드4
 * 
 * @author SSAFY
 *
 */
public class boj_17471 {

	static int N;
	static int[] Population;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		Population = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList();
		}
		st = new StringTokenizer(br.readLine());

		// 혹시나 하는 초기화 처리
		Population[0] = Integer.MIN_VALUE;

		for (int i = 1; i < N + 1; i++) {
			Population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(!list[i].contains(temp)) {
					list[i].add(temp);
					list[temp].add(i);					
				}
			}
		}
		
		// make combination 부분 집합
		visit = new boolean[N];
		make_combination(0);

	}
	
	static boolean[] visit;
	private static void make_combination(int depth) {
		if(depth == N) {
			System.out.println(Arrays.toString(visit));
			
			return;
		}
		
		visit[depth] = true;
		make_combination(depth + 1);
		
		visit[depth] = false;
		make_combination(depth + 1);
		
		
	}

}
