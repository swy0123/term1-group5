package algorithm;

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
 * boj_1194 달이 차오른다, 가자. 골드1
 * 
 * @author SSAFY
 *
 */
public class boj_1194 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row, col;
		List<Character> key = new ArrayList<>();

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", key=" + key + "]";
		}

		public Point(int row, int col, List<Character> key) {
			super();
			this.row = row;
			this.col = col;
			this.key = key;
		}

		public int get_demension() {
			int temp = 0;
			for (int i = 0; i < key.size(); i++) {
				temp += key.get(i) - 'a' + 1;
			}

			return temp;
		}

		public boolean open_the_door(char c) {
			return key.contains(c);
		}

	}

	static int N, M;
	static char[][] map;
	static Point start;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M][22]; // 'a' - 'a' + 1 + 'b' - 'a' + 1 ...

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = sb.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					start = new Point(i, j);
				}
			}
		}

		// bfs
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visit[start.row][start.col][start.get_demension()] = true;
		int size = 0;
		int level = 0;

		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (map[p.row][p.col] == '1') {
					System.out.println(level);
					System.exit(0);
				}

				for (int j = 0; j < dir.length; j++) {
					int nr = p.row + dir[j][0];
					int nc = p.col + dir[j][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						char c = map[nr][nc];
						
						
						if ((c == '.' && !visit[nr][nc][p.get_demension()])) { // go
							visit[nr][nc][p.get_demension()] = true;
							q.offer(new Point(nr, nc, new ArrayList<>(p.key)));
						} else if (c >= 'a' && c <= 'f' && !visit[nr][nc][p.get_demension()]) { // 키

							if (p.key.contains(c)) {
								visit[nr][nc][p.get_demension()] = true;
								q.offer(new Point(nr, nc, new ArrayList<>(p.key)));
								continue;
							}

							// 키를 집어듬
							visit[nr][nc][p.get_demension()] = true; //
							List<Character> n_key = new ArrayList<>(p.key);
							n_key.add(c);
							Point np = new Point(nr, nc, n_key);
							visit[np.row][np.col][np.get_demension()] = true;
							
							q.offer(np);
						} else if (c >= 'A' && c <= 'F' && !visit[nr][nc][p.get_demension()]) { // 문
							// 문을 만남
							if (p.open_the_door(Character.toLowerCase(c))) {// 문이 열리는지 확인
								visit[nr][nc][p.get_demension()] = true;
								q.offer(new Point(nr, nc, new ArrayList<>(p.key)));
							}
						} else if (c == '1') { // 도착
							q.offer(new Point(nr, nc));
						}
						// 벽
					}
				}
			}
//			System.out.println(Arrays.toString(q.toArray()));
			level++;
		}

		System.out.println(-1);
	}

}
