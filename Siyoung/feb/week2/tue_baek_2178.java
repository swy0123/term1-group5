package feb.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 2178 미로탐색
 */
public class tue_baek_2178 {

	static class Point{
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	static int n, m, len;
	static int[][] map;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		len = 0;
		map = new int[n][m];
		String str;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(n,m);
//		System.out.println(len);
	}
	
	private static void bfs(int t1, int t2) {
		boolean[][] v = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1));
		v[0][0] = true;
		while(!q.isEmpty()) {
			Point cp = q.poll();
//			System.out.println(cp.i +" "+ cp.j+" "+cp.cnt);
			if(cp.i == t1-1 && cp.j == t2-1) {
				System.out.println(cp.cnt);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ni = cp.i+di[i];
				int nj = cp.j+dj[i];
//				System.out.println("n "+ni +" "+nj);
				if( ni>=0 && ni < n && nj >=0 && nj < m) {
					if(map[ni][nj] == 1 && !v[ni][nj]) {
						v[ni][nj] = true;
						q.add(new Point(ni, nj, cp.cnt+1));
//						len = Math.max(len, cp.cnt+1);
					}
				}
			}
			
			
		}
		
	}

}
