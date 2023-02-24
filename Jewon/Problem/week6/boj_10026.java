package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_10026 적록색약 골드 5
 * 
 * @author SSAFY
 *
 */
public class boj_10026 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static char[][] map1;
	static char[][] map2;

	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map1 = new char[N][N];
		map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				map2[i][j] = map1[i][j] = sb.charAt(j);
			}
		}
		
		// 정상인
		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map1[i][j] != '.') {
					bfs_1(i, j, map1[i][j]);
					cnt1++;
				}
			}
		}
		
		// 비정상인
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] != '.') {
					bfs_2(i, j, map2[i][j]);
					cnt2++;
//					print(map2);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}



	private static void print(char[][] map) {
		System.out.println("===========================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}



	private static void bfs_2(int row, int col, char color) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][N];
		visit[row][col] = true;
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < N && !visit[nr][nc]) {
					if(color == 'R' || color == 'G') {
						if(map2[nr][nc] == 'R' || map2[nr][nc] == 'G' ) {
							visit[nr][nc] = true;
							map2[nr][nc] = '.';
							q.offer(new Point(nr,nc));
						}
					}else if(map2[nr][nc] == 'B'){
						visit[nr][nc] = true;
						map2[nr][nc] = '.';
						q.offer(new Point(nr,nc));
					}

				}
			}
		}

	}
	
	private static void bfs_1(int row, int col, char color) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][N];
		visit[row][col] = true;
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < N && !visit[nr][nc] && map1[nr][nc] == color) {
					visit[nr][nc] = true;
					map1[nr][nc] = '.';
					q.offer(new Point(nr,nc));				
				}
			}
		}
		
	}

}
