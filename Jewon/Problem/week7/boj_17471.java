package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	static int Ans = Integer.MAX_VALUE;
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
		
//		for (int i = 1; i < N+1; i++) {
//			System.out.println(Arrays.toString(list[i].toArray()));
//		}
		
		
		// make combination 부분 집합
		visit = new boolean[N];
		make_combination(0);
		
		if(Ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(Ans);			
		}
	}
	
	static boolean[] visit;
	static boolean[] visit_1;
	static boolean[] visit_2;
	private static void make_combination(int depth) {
		if(depth == N) {
			List<Integer> list_1 = new ArrayList<>(); 
			visit_1 = new boolean[N+1];
			
			List<Integer> list_2 = new ArrayList<>(); 
			visit_2 = new boolean[N+1];
			
//			System.out.println(Arrays.toString(visit));
			
			// 구역 나누기
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					list_1.add(i+1);
					visit_1[i+1] = true;
				}else {
					list_2.add(i+1);
					visit_2[i+1] = true;
				}
			}
			
			// 구역 제대로 나누었는지 체크
			if(list_1.size() == 0 || list_2.size() == 0) {
				return;
			}
			
			// dfs를 통해 그래프가 연결되었는지 체크하기
			if(bfs(list_1, visit_1) && bfs(list_2, visit_2)) {
				// 인구수 차이 구하기
				int sum1 = 0, sum2 = 0;
				
				for (int i = 0; i < list_1.size(); i++) {
					sum1 += Population[list_1.get(i)];
				}
				
				for (int i = 0; i < list_2.size(); i++) {
					sum2 += Population[list_2.get(i)];
				}
				
				Ans = Math.min(Ans, Math.abs(sum1 - sum2));
				
			}
			
			return;
		}
		
		visit[depth] = true;
		make_combination(depth + 1);
		
		visit[depth] = false;
		make_combination(depth + 1);
		
		
	}
	
	// 가능한 방문후 구역이 연결되어있으면 true, 아니면 false
	private static boolean bfs(List<Integer> checkList, boolean[] visit) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(checkList.get(0));
		visit[checkList.get(0)] = false;
		
		while(!q.isEmpty()) {
			int i = q.poll();
			
			for(int next : list[i]) {
				if(visit[next]) {
					visit[next] = false;
					q.offer(next);
				}
			}
		}
		
		//모든 방문 배열이 false인지 체크하기
		for (int i = 0; i < visit.length; i++) {
			if(visit[i] == true) {
				return false;
			}
		}
		
		return true;
	}

}
