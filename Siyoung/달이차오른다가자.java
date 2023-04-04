package se;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * # 벽  a - f : 열쇠 A - F : 문 0: 현재위치
 */

public class 달이차오른다가자 {
	static int n, m, si, sj;
	static int Ans = Integer.MAX_VALUE;
	static char[][] map;
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt, key;
		// int[] key = new int[6];

		public Point(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		int si=0, sj=0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					si=i;
					sj=j;
				}
			}
		}

		// bfs gogo
		Queue<Point> q = new LinkedList();
		boolean[][][] v = new boolean[n][m][1 << 6];
		q.add(new Point(si, sj, 0, 0));
		v[si][sj][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (map[p.r][p.c] == '1') {
				Ans = Math.min(Ans, p.cnt);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nkey = p.key;

				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !v[nr][nc][nkey] && map[nr][nc] != '#') {
					// 키를 만났을 경우 키를 습득한다
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						nkey = nkey | (1 << (map[nr][nc] - 'a'));
					}
					// 문을 만났을 경우 키의 여부를 확인하고 그에 따라 이동한다
					if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						// >0 키가 있다면 == 0 키가 없다면
						// continue 해서 이동하지 못하게 한다
						if ((nkey & (1 << (map[nr][nc] - 'a'))) == 0) {
							continue;
						}
					}
					v[nr][nc][nkey] = true;
					q.add(new Point(nr, nc, p.cnt + 1, nkey));
				}
			}
		}

		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}
	}
}
