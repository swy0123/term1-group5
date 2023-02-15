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
	static int[][] room;
	static int n, resNum, resCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			resNum = Integer.MAX_VALUE;
			resCnt = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}
			
			System.out.println("#" + testCase + " " + resNum + " " + resCnt);
		}
	}
	
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(sx, sy));
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (size-- > 0) {
				int x = q.peek().x;
				int y = q.poll().y;

				for (int i = 0; i < 4; i++) {
					int nx = x + del[i][0];
					int ny = y + del[i][1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || room[nx][ny] != (room[x][y] + 1)) continue;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		if (resCnt <= cnt) {
			resNum = (resCnt == cnt? Math.min(room[sx][sy], resNum) : room[sx][sy]);
			resCnt = cnt;
		}
	}
}
