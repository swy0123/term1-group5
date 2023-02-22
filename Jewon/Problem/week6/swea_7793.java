package specialweek01;

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
 * swea_7793 오! 나의 여신님 D5
 * 
 * @author SSAFY
 *
 */
public class swea_7793 {
	static int N;
	static int M;
	static char[][] map;

	static class Point {
		int row;
		int col;

		int job; // 0 devil , 1 human

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public Point(int row, int col, int job) {
			super();
			this.row = row;
			this.col = col;
			this.job = job;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", job=" + job + "]";
		}

		

	}

	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int ans;
	static boolean[][] S_visit;
	static boolean[][] D_visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Point person = null;
			List<Point> devils = new ArrayList<Point>();

			map = new char[N][M];
			S_visit = new boolean[N][M];
			D_visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = sb.charAt(j);

					if (map[i][j] == '*') {
						devils.add(new Point(i, j, 0));
					}

					if (map[i][j] == 'S') {
						person = new Point(i, j, 1);
					}
				}
			}

			//
			bfs(person, devils);
			if(ans == 0) {
				System.out.println("#" + test_case + " GAME OVER");
			}else {
				System.out.println("#" + test_case + " " + ans);				
			}
		}
	}

	private static void bfs(Point person, List<Point> devils) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(person);
		S_visit[person.row][person.col] = true;
		
		for (int i = 0; i < devils.size(); i++) {
			Point d = devils.get(i);
			q.offer(d);
			D_visit[d.row][d.col] = true;
		}

		int level = 0;

		while (!q.isEmpty() && is_human(q)) {
			int size = q.size();

			for (int cnt = 0; cnt < size; cnt++) {
				Point p = q.poll();
				// 인간일 경우 연제 불에 맞아 있으면 죽음
				if(p.job == 1) {
					if(D_visit[p.row][p.col] == true) {
						//으앙
						continue;
					}
				}
				
				
				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					// 범위내 && 돌이 아님
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 'X') {
						// 인간? 악마?
						if (p.job == 1) { // 인간
							// 해당 좌표에 악마의 스킬이 없으며 방문하지 않은 위치
							if (map[nr][nc] == 'D') {
								// 야호!
								ans = level + 1;
								return;
							}

							if (D_visit[nr][nc] != true && S_visit[nr][nc] == false) {
								S_visit[nr][nc] = true;
								q.offer(new Point(nr, nc, 1));
							}
						} else { // 악마
							// 해당 칸에 인간이 있으면 죽임
							
							if (D_visit[nr][nc] == false && map[nr][nc] != 'D') {
								D_visit[nr][nc] = true;
								q.offer(new Point(nr, nc, 0));
							}
						}
					}
				}
			}
//			System.out.println(Arrays.toString(q.toArray()));
			level++;
		}
	}

	private static boolean is_human(Queue<Point> q) {
		Queue<Point> qq = new LinkedList<Point>(q);
		int size = qq.size();
		
		for (int i = 0; i < size; i++) {
			Point p = qq.poll();
			if (p.job == 1) {
				return true;
			}
		}
		return false;
	}

}
