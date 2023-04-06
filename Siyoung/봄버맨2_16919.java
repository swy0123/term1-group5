package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봄버맨2_16919 {
	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int r, c, n;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken())-1;
		
		map = new int[r][c];
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				if(str.charAt(j)=='.') map[i][j] = 0;
				if(str.charAt(j)=='O') map[i][j] = 3;
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}System.out.println();
		
		solve();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]>0) System.out.print('O');
				else System.out.print('.');
			}System.out.println();
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
	}
	
	// 숫자로 저장
	// 0인 곳에 설치
	//매 초마다 1 감소
	//1이 될 시 사방 탐색 후 파괴
	private static void solve() {
		
		Queue<point> q = new LinkedList<>();
		if(n>0) n=n%4+4;
		for(int time=n; time>=0; time--) {
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(time==n&& map[i][j]==0) {
						continue;
					}
//					if(flag && map[i][j]==0) {
//						continue;
//					}
					map[i][j]--;
					if(map[i][j]==-1) map[i][j]=3;
					if(map[i][j]==0) q.add(new point(i, j));
				}
			}
			while(!q.isEmpty()) {
				point p = q.poll();
				for(int d=0; d<4; d++) {
					int ni=p.i+di[d];
					int nj=p.j+dj[d];
					if(ni>=0 && ni<r && nj>=0 && nj<c && map[ni][nj]>0) {
						map[ni][nj]=0;
					}
				}
			}
//			System.out.println(n-time+1);
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
		}
		
	}
	
	
}
