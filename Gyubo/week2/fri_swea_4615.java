import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;

public class fri_swea_4615 {
	// 북 북동 동 동남 남 남서 서 북서
	private static final int[][] move = { { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 },
			{ -1, -1 } };
	private static final String List = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < testCase + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] table = new int[n][n];

			// 초기값 설정
			table[n / 2 - 1][n / 2 - 1] = 2;
			table[n / 2 - 1][n / 2] = 1;
			table[n / 2][n / 2 - 1] = 1;
			table[n / 2][n / 2] = 2;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int stone = Integer.parseInt(st.nextToken());

				table[y][x] = stone;
				// 놓은곳을 기준으로 8방 탐색
				// 탐색결과 자신의 돌과 같은색의 돌이 있으면 사이의 돌 색 변경

				for (int j = 0; j < 8; j++) {
					int curX = x;
					int curY = y;
					List<Integer> xCoords = new ArrayList<>();
					List<Integer> yCoords = new ArrayList<>();
					while (true) {
						int nx = curX + move[j][0];
						int ny = curY + move[j][1];

						if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
							break;
						}
						if (table[ny][nx] == 0) {
							break;
						}

						if (table[ny][nx] == stone) {
							// (x ,y) 부터 (nx, ny) 까지 모두 색상변경
							for (int k = 0; k< xCoords.size(); k++) {
								table[yCoords.get(k)][xCoords.get(k)] = stone;
							}
							break;
						}
						
						xCoords.add(nx);
						yCoords.add(ny);
						curX = nx;
						curY = ny;
					}
				}
//				for (int[] js : table) {
//					for (int js2 : js) {
//						System.out.print(js2 + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
			int whiteCount = 0;
			int blackCount = 0;
			
			for (int[] is : table) {
				for (int value : is) {
					if (value == 1) {
						whiteCount++;
					}
					else if (value == 2) {
						blackCount++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + whiteCount + " " + blackCount);

		}
	}
}
