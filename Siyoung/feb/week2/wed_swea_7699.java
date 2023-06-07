package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * swea 7699. 수지의 수지 맞는 여행
 */
public class wed_swea_7699 {
	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int max;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[n][m];
			int[] c = new int[26];
			boolean[][] v = new boolean[n][m];
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
//			for (char[] h : map) {
//				System.out.println(Arrays.toString(h));
//			}
			max = 0;
			v[0][0] = true;
			c[map[0][0]-'A'] = 1;
			back(map, c, v, 0, 0, 1);
			System.out.println("#"+test_case+" "+max);
			
			
		}
	}

	private static void back(char[][] map, int[] c, boolean[][] v, int i, int j, int cnt) {
		max = Math.max(max, cnt);
		for(int d=0; d<4; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<map.length && cj>=0 && cj<map[0].length) {
				if(c[map[ci][cj]-'A'] == 0 && !v[ci][cj]) {
					c[map[ci][cj]-'A'] = 1;
					v[ci][cj] = true;
					back(map, c, v, ci, cj, cnt+1);
					c[map[ci][cj]-'A'] = 0;
					v[ci][cj] = false;
				}
			}
		}
		
		
	}
	
	
//	private static void dfs(char[][] map) {
//		int[] c = new int[26];
//		boolean[][] v = new boolean[map.length][map[0].length];
//		max = 0;
//		
//		Stack<point> s = new Stack<>();
//		s.add(new point(0, 0, 1));
//		
//		
//		while(!s.isEmpty()) {
//			point p = s.pop();
//			v[p.i][p.j] = true;
//			c[map[p.i][p.j]-'A'] = 1;
//			System.out.println(p.i+" "+p.j+" "+p.cnt );
//			
//			boolean flag = false;
//			for(int d=0; d<4; d++) {
//				int ci = p.i+di[d];
//				int cj = p.j+dj[d];
//				if(ci>=0 && ci<map.length && cj>=0 && cj<map[0].length) {
//					if(c[map[ci][cj]-'A'] == 0 && !v[ci][cj]) {
//						flag = true;
//						s.add(new point(ci, cj, p.cnt+1));
//						max = Math.max(max, p.cnt+1);
//					}
//				}
//			}
//			if(!flag) c[map[p.i][p.j]-'A'] = 0;
//			
//		}
//		
//		
//		
//		
//	}
	

}
