import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fri_Problem22 {

	private static final int[][] move = { { 0, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	private static final int[] size = { 3, 2, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < testCase + 1; tc++) {

			// 입력처리

			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int bug = Integer.parseInt(input[1]);

			boolean[][] visited = new boolean[n][n];
			int[][] bugs = new int[bug][3];
			int deathCount = 0;

			for (int i = 0; i < bug; i++) {
				String[] split = br.readLine().split(" ");
				for (int j = 0; j < split.length; j++) {
					bugs[i][j] = Integer.parseInt(split[j]);
				}
			}
			// 입력처리

			// 초기 위치 방문여부 조사
			// 방문했다면 deathCount++
			// 입력받은 결과값으로 방향 벡터를 선정
			// for 3 2 1 새로운 위치값 갱신
			// /방향벡터 *3 *2 *1
			// /범위를 벗어났다면 deathcount ++
			// /방문한 곳을 방문했다면 deathCount ++
			// /deathCount++ 되면 break
			// break가 되지 않았다면 마지막 위치 방문처리

			for (int i = 0; i < bug; i++) {
				int y = bugs[i][0];
				int x = bugs[i][1];
				int dir = bugs[i][2];

				if (visited[y][x] == true) {
					deathCount++;
					continue;
				}

				boolean flag = false;
				for (int j = 0; j < 3; j++) {
					y = y + move[dir][1] * size[j];
					x = x + move[dir][0] * size[j];

					if (x < 0 || x >= n || y < 0 || y >= n) {
						deathCount++;
						flag = true;
						break;
					}
					if (visited[y][x]) {
						deathCount++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					visited[y][x] = true;
				}

			}

			// 테스트 케이스 마무리
			System.out.println("#" + tc + " " + (bug - deathCount));
		}
	}
}
