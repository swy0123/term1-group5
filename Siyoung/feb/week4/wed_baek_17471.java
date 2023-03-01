package week4;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 17471 게리맨더링
 */
public class wed_baek_17471 {

	static boolean[][] map;
	static int[] pop;
	static int n, check, min = Integer.MAX_VALUE;
	static boolean[] v, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new boolean[n+1][n+1];
		pop = new int[n+1];
		v = new boolean[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt, d;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for(int j=1; j<=cnt; j++) {
				d = Integer.parseInt(st.nextToken());
				map[i][d] = true;
				map[d][i] = true;
			}
		}
		
		subset(1);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	private static void subset(int idx) {
		if(idx == n+1) {
			int sum1=0, sum2=0;
			visited = new boolean[n+1];
			sum1 = bfs(true);
			sum2 = bfs(false);
			
			for (int i=1; i<=n; i++) {
				if(!visited[i]) return;
			}
//			System.out.println(Arrays.toString(v));
//			System.out.println(sum1 +" "+sum2);
			min = Math.min(Math.abs(sum1-sum2), min);
			
			return;
		}
		
		v[idx] = true;
		subset(idx+1);
		v[idx] = false;
		subset(idx+1);
	}

	private static int bfs(boolean flag) {
		int start = 0;
		for(int i=1; i<=n; i++) {
			if(v[i]==flag) {
				start = i;
				break;
			}
		}
		if(start == 0) return 0;
		
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		int tmp = pop[start];
		q.add(start);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(map[c][i] && !visited[i] && v[i] == flag) {
					q.add(i);
					visited[i] = true;
					tmp += pop[i];
				}
			}
			
		}
		
		return tmp;
	}
}
