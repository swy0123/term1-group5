import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1 {
	static int N;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class Player {
		int row, col;
		int dir;

		public Player(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Player [row=" + row + ", col=" + col + ", dir=" + dir + "]";
		}

	}

	static class Point implements Comparable<Point> {
		int row, col;
		int num;

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

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}
	}

	static PriorityQueue<Point> q;
	static Player player;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			player = new Player(0, 0, 1);
			q = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						q.offer(new Point(i, j, map[i][j]));
					}
				}
			}
			//
//			System.out.println(Arrays.toString(q.toArray()));
			int round_size = q.size();
			for (int round = 0; round < round_size; round++) {
				Point target = q.poll();
				// 앞에 있는 경우
				calc(player, target);

//				System.out.println(target + " " + cnt + " " + player);
				// 플레이어 기준으로 어디에 있는가?

			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void calc(Player player, Point target) {
		int current_dir = player.dir;
		// 좌표 세팅

		switch (current_dir) {
		case 0:
			// 1사분면
			if (player.row > target.row && target.col == player.col) {
				// 냠
			} else if (player.row >= target.row && player.col < target.col) { // 1
				// 한번
				cnt += 1;
				player.dir = 1;
			} else if (player.row < target.row && player.col < target.col) { // 2
				// 두번
				cnt += 2;
				player.dir = 2;
			} else if (player.col >= target.col) { // 3
				// 세번
				cnt += 3;
				player.dir = 3;
			}else {
				System.out.println("error0");
			}


			break;
		case 1:
			if (player.row == target.row && player.col < target.col) { // 0
				// 냠
			} else if (player.row < target.row && player.col <= target.col) {
				// 1
				cnt += 1;
				player.dir = 2;
			} else if (player.row < target.row && player.col > target.col) { // 0
				// 2
				cnt += 2;
				player.dir = 3;
			} else if (player.row >= target.row) {
				// 3
				cnt += 3;
				player.dir = 0;
			}else {
				System.out.println("error1");
			}

			break;
		case 2:
			if (player.col == target.col && player.row < target.row) {
				// 냠
			} else if (player.row <= target.row && player.col > target.col) { // 0
				// 1
				cnt += 1;
				player.dir = 3;
			} else if (player.row > target.row && player.col > target.col) { // ?
				// 2
				cnt += 2;
				player.dir = 0;
			} else if (player.col <= target.col) {
				// 3
				cnt += 3;
				player.dir = 1;
			}else {
				System.out.println("error2");
			}

			break;
		case 3:
			if (player.row == target.row && player.col > target.col) {
				// 냠
			} else if (player.row > target.row && player.col >= target.col) { // 0
				// 1
				cnt += 1;
				player.dir = 0;
			} else if (player.row > target.row && player.col < target.col) { // 0
				// 2
				cnt += 2;
				player.dir = 1;
			} else if (player.row <= target.row) { // 0
				// 3
				cnt += 3;
				player.dir = 2;
			}else {
				System.out.println("error3");
			}

			break;
		}
		player.row = target.row;
		player.col = target.col;

	}

}
