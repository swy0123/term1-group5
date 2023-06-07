import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] cheese, tmpCheese;
	static int n, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());
			cheese = new int[n][n];
			tmpCheese = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int day = -1;
			res = 0;
			while(++day <= 100) {
				eatCheese(day);
				res = Math.max(res, count());
			}
			System.out.println("#" + testCase + " " + res);
		}
	}
	
	private static void eatCheese(int day) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cheese[i][j] == day) cheese[i][j] = 0;
			}
		}	
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmpCheese[i][j] = cheese[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmpCheese[i][j] != 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new ArrayDeque<>();
		tmpCheese[sx][sy] = 0;
		q.offer(new Pair(sx, sy));

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int i = 0; i < 4; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || tmpCheese[nx][ny] == 0) continue;
				tmpCheese[nx][ny] = 0;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}
