import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 낚시왕
public class fri_beak_17143 {

	static class Shark {
		int y;
		int x;
		int speed;
		int dir;
		int size;

		public Shark(int y, int x, int speed, int dir, int size) {
			super();
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		public void move(Shark[][] tmpTable) {
			int r;
			if (dir == 1 || dir == 2) {
				r = speed % ((tmpTable.length - 1) * 2 - 2);
			} else {
				r = speed % ((tmpTable[0].length - 1) * 2 - 2);
			}

			// 나머지 만큼 탐색
			for (int i = 0; i < r; i++) {
				int ny = y + vector[dir][0];
				int nx = x + vector[dir][1];

				if (ny < 1 || nx < 1 || ny >= tmpTable.length || nx >= tmpTable[0].length) {
					changeDir();
					i--;
					continue;
				}
				y = ny;
				x = nx;
			}

			if (tmpTable[y][x] != null) {
				if (canEat(tmpTable[y][x])) {
					tmpTable[y][x] = this;
				}
			} else {
				tmpTable[y][x] = this;
			}
		}

		private boolean canEat(Shark shark) {
			if (shark.size > this.size) {
				return false;
			} else {
				return true;
			}
		}

		private void changeDir() {
			if (this.dir == 1) {
				this.dir = 2;
				return;
			}
			if (this.dir == 2) {
				this.dir = 1;
				return;
			}
			if (this.dir == 3) {
				this.dir = 4;
				return;
			}
			if (this.dir == 4) {
				this.dir = 3;
				return;
			}
		}
	}

	private static final int[][] vector = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Shark[][] table = new Shark[r + 1][c + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			table[y][x] = new Shark(y, x, speed, dir, size);
		}

		long score = 0;
		for (int fisherPos = 1; fisherPos < table[0].length; fisherPos++) {
			// 상어잡기
			for (int y = 1; y < table.length; y++) {
				if (table[y][fisherPos] != null) {
					score += table[y][fisherPos].size;
					table[y][fisherPos] = null;
					break;
				}
			}
			// 상어 이동처리
			// 새로운 태이블에 만들어서 거기에다가 이동한 상어를 붙인다.
			Shark[][] tmpTable = new Shark[table.length][table[0].length];
			for (int i = 1; i < table.length; i++) {
				for (int j = 1; j < table[0].length; j++) {
					if (table[i][j] != null) {
						table[i][j].move(tmpTable);
					}
				}
			}
			table = tmpTable;
		}
		System.out.println(score);
	}
}
