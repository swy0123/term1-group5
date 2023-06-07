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
 * 
 * boj_16236 아기 상어 골드 3
 * 
 * @author SSAFY
 *
 */
public class boj_16236 {
	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] sizelist = new int[7];
	static int N;
	static int[][] map;
	static List<Point> list = new ArrayList<Point>();
	static Point babyshark;
	static int totaltime = 0;
	static boolean[][] visitmap;

	static class Point {
		int row;
		int col;
		int size;

		int eatN;

		public Point(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			this.size = -1;
		}

		public void setPosition(Point p) {
			this.row = p.row;
			this.col = p.col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", size=" + size + ", eatN=" + eatN + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
//				map[i][j] = Integer.parseInt(st.nextToken());

				map[i][j] = temp;

				if (temp == 9) { // 아기 상어
					babyshark = new Point(i, j, 2);

				} else if (temp > 0 && temp != 9) { // 물고기
//					list.add(new Point(i, j, temp));
					sizelist[map[i][j]]++;
				}

			}
		}

		// debug
//		System.out.println(Arrays.toString(sizelist));

		// list 정렬
		// size가 작은순
		// size가 같으면 가까운순
		// 거리를 BFS로 해야하는데 ??
		// BFS순회로 가장 가까운 거리의 물고리부터 먹는다
		// 거리가 같으면 위에있는놈 즉 row가 제일 작은순
		// row또한 같으면 가장왼쪽 row col이 제일 작은순

		while (check()) {
			if (!bfs()) {
				// 엄마!
				break;
			}
		}

		System.out.println(totaltime);
	}

	private static boolean bfs() {
		// visit 필요한가?
		visitmap = new boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		List<Point> list = new ArrayList<Point>();

		q.offer(babyshark);
		map[babyshark.row][babyshark.col] = 0;
		visitmap[babyshark.row][babyshark.col] = true;

		int level = 0;
		int size = 0;

		while (!q.isEmpty()) {
			size = q.size();

			for (int cnt = 0; cnt < size; cnt++) {
				Point p = q.poll();

				for (int i = 0; i < dir.length; i++) {
					int nr = p.row + dir[i][0];
					int nc = p.col + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <= babyshark.size
							&& visitmap[nr][nc] == false) {
						// 먹을수 있는 물고기를 만났나?
						visitmap[nr][nc] = true;
						if (map[nr][nc] > 0 && map[nr][nc] < babyshark.size) {
							list.add(new Point(nr, nc, map[nr][nc]));
						} else {
							q.offer(new Point(nr, nc));
						}
					}
				}
				// 좌표가 범위 내인가 && 아기 상어보다 작은곳인가
			}

			level++;
			if (!list.isEmpty()) {
				break;
			}
		}
		// 더이상 먹을 물고기가 없는 경우;
		if (list.isEmpty()) {
			return false;
		}

		// 거리가 같으며 먹을수 있는 물고기가 여러명인 경우 가장 우선순위가 높은 fish 탐색
		Point eatingFish = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Point tempFish = list.get(i);
			if (eatingFish.row > tempFish.row) {
				eatingFish = tempFish;
			} else if (eatingFish.row == tempFish.row) {
				if (eatingFish.col > tempFish.col) {
					eatingFish = tempFish;
				}
			}
		}

		// 물고기 먹기
		babyshark.setPosition(eatingFish);
		map[babyshark.row][babyshark.col] = 0;
		babyshark.eatN += 1;
		if (babyshark.eatN == babyshark.size) {
			babyshark.size++;
			babyshark.eatN = 0;
		}
		sizelist[eatingFish.size]--;

		totaltime += level; // 시간 계산하기
		return true;
	}

	private static boolean check() {
		// 현재 아기 상어 보다 작은 물고기가 있는가?
		if (babyshark.size > 7) {
			return true;
		}

		for (int i = 1; i < babyshark.size; i++) {
			if (sizelist[i] > 0)
				return true;
		}
		return false;
	}

}
