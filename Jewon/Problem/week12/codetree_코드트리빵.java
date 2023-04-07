package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author SSAFY
 * 
 *         1 격자에 있는 사람들이 본인이 가고 싶은 편의점 방향을 향해서 1 칸 움직입니다. 최단거리로 움직이며 최단 거리로 움직이는
 *         방법이 여러가지라면 ↑, ←, →, ↓ 의 우선 순위로 움직이게 됩니다. 여기서 최단거리라 함은 상하좌우 인접한 칸 중
 *         이동가능한 칸으로만 이동하여 도달하기까지 거쳐야 하는 칸의 수가 최소가 되는 거리를 뜻합니다.
 * 
 *         2 만약 편의점에 도착한다면 해당 편의점에서 멈추게 되고, 이때부터 다른 사람들은 해당 편의점이 있는 칸을 지나갈 수 없게
 *         됩니다.
 * 
 *         3 현재 시간이 t분이고 t ≤ m를 만족한다면, t번 사람은 자신이 가고 싶은 편의점과 가장 가까이 있는 베이스 캠프에
 *         들어갑니다. 여기서 가장 가까이에 있다는 뜻 역시 1에서와 같이 최단거리에 해당하는 곳을 의미합니다. 가장 가까운
 *         베이스캠프가 여러 가지인 경우에는 그 중 행이 작은 베이스캠프, 행이 같다면 열이 작은 베이스 캠프로 들어갑니다. t번
 *         사람이 베이스 캠프로 이동하는 데에는 시간이 전혀 소요되지 않습니다.
 * 
 *         이때부터 다른 사람들은 해당 베이스 캠프가 있는 칸을 지나갈 수 없게 됩니다. t번 사람이 편의점을 향해 움직이기
 *         시작했더라도 해당 베이스 캠프는 앞으로 절대 지나갈 수 없음에 유의합니다.
 */
public class codetree_코드트리빵 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row, col;
		int num;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public Point(int row, int col, int num) {
			super();
			this.row = row;
			this.col = col;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", num=" + num + "]";
		}

	}

	static int N, M;
	static int[][] map;
	static Point[] drugStores;
	static boolean[][] base;
	static boolean[][] drug;
	static boolean[][][] map_visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		base = new boolean[N][N];
		drug = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		drugStores = new Point[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			drugStores[i] = new Point(x, y);
		}

		// 사람이 뒤로 가는것을 방지하는 Visit 배열
		map_visit = new boolean[M][N][N];
		// 다음 약국과 가까운 베이스 캠프 찾기
		Point start_base = find_start_base(drugStores[0], base);
		start_base.num = 0;

		Queue<Point> Q = new LinkedList<>();
		map_visit[0][start_base.row][start_base.col] = true;
		base[start_base.row][start_base.col] = true;
		Q.offer(start_base);

		int level = 1;
		while (!Q.isEmpty()) {

			int size = Q.size();

			for (int i = 0; i < size; i++) {
				Point p = Q.poll();

				// 이미 도착한 사람인가
				if (drug[drugStores[p.num].row][drugStores[p.num].col]) {
					continue;
				}

				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];
					if (isRange(nr, nc) && !map_visit[p.num][nr][nc] && !base[nr][nc] && !drug[nr][nc]) {
						map_visit[p.num][nr][nc] = true;

						// 여기서 도착한지 체크 해야만 아래 find_start_base에서의 반례를 해결할수 있음.
						// 또한 Q에 들어가는 허수를 줄여서 시간적으로도 유리해짐

						if (drugStores[p.num].row == nr && drugStores[p.num].col == nc) {
							drug[drugStores[p.num].row][drugStores[p.num].col] = true;
						} else {
							Q.offer(new Point(nr, nc, p.num));
						}

					}
				}

			}

			if (!check(drug)) {
				break;
			}

			if (level < M) {
				start_base = find_start_base(drugStores[level], base);
				start_base.num = level;

				map_visit[start_base.num][start_base.row][start_base.col] = true;
				base[start_base.row][start_base.col] = true;
				Q.offer(start_base);
			}

			level++;
		}

		System.out.println(level + 1);
	}

	private static boolean check(boolean[][] drug) {
		for (int i = 0; i < drugStores.length; i++) {
			if (!drug[drugStores[i].row][drugStores[i].col]) {
				return true;
			}
		}
		return false;
	}

	private static Point find_start_base(Point drugStore, boolean[][] base_drug) {
		boolean[][] visit = new boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		q.offer(drugStore);
		visit[drugStore.row][drugStore.col] = true;
		int level = 0;

		Queue<Point> bases = new LinkedList<Point>();

		// 가까운 베이스 캠프 위치를 구한다.
		while (!q.isEmpty()) {
			int size = q.size();
			if (bases.size() > 0)
				break;

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					// 방문 하지않았으며, 도착된 약국이 아니며, 닫힘 베이스도 아니어야함
					if (isRange(nr, nc) && !visit[nr][nc] && !drug[nr][nc] && !base[nr][nc]) {
						visit[nr][nc] = true;
						q.offer(new Point(nr, nc));
						if (map[nr][nc] == 1 && !base[nr][nc]) {
							bases.offer(new Point(nr, nc));
						}
					}
				}
			}
		}

		Point base = bases.poll();
		int size = bases.size();
		for (int i = 0; i < size; i++) {
			Point temp = bases.poll();
			if (base.row > temp.row) {
				base = temp;
			} else if (base.row == temp.row) {
				if (base.col > temp.col) {
					base = temp;
				}
			}
		}

		return base;
	}

	private static boolean isRange(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < N);
	}

}
