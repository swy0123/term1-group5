package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {
	static int M;
	static int N;
	static int[][] map;
	static int[][] visitmap;
	static int cnt = 0;

	// 서 남 동 북
	static int[][] deltas = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로
		map = new int[M][N];
		visitmap = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visitmap[i][j] = -1;
			}
		}

		System.out.println(path(0, 0));
//		for (int i = 0; i < visitmap.length; i++) {
//			System.out.println(Arrays.toString(visitmap[i]));
//		}
//		System.out.println(map[M - 1][N - 1]);
	}

	private static int path(int x, int y) {
		// TODO Auto-generated method stub
		
		
		if (x == M - 1 && y == N - 1) {
//			System.out.println("---------------------------");
			return 1;
		}

		if (visitmap[x][y] != -1 ) {
			return visitmap[x][y];
		}
		
		if(map[x][y] < map[M - 1][N - 1]) {
			return 0;
		}
		
		visitmap[x][y] = 0;
		
		for (int i = 0; i < deltas.length; i++) {
			int nx = x + deltas[i][0];
			int ny = y + deltas[i][1];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {

				if (map[x][y] > map[nx][ny]) {

					visitmap[x][y] += path(nx, ny);
				}
			}
		}

		return visitmap[x][y];
	}
}