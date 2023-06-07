import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fri_Problem32 {

	private static final int[][] move = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 0; tc < testCase; tc++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int members = sc.nextInt();
			int result = 0;

			// 테이블 입력 처리
			int[][][] table = new int[rows][cols][2];
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					String input = sc.next();
					for (int i = 0; i < 2; i++) {
						table[r][c][i] = Character.getNumericValue(input.charAt(i));
					}
				}
			}
			
			// 플레이어 입력 처리 y x 횟수 순으로 저장
			List<List<Integer>> player = new ArrayList<>();
			for (int i = 0; i < members; i++) {
				List<Integer> tmp = new ArrayList<>();

				tmp.add(sc.nextInt() - 1);
				tmp.add(sc.nextInt() - 1);
				tmp.add(sc.nextInt());

				player.add(tmp);
			}

			// 함정 처리 -> 함정은 null
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int y = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				table[y][x] = null;
			}

			/**
			 * 
			 * for (횟수) 현재 위치에서 방향과 거리 파악 이동후 null인지 체크 좌표를 벗어난다면 break 함정에 빠진다면 break
			 * 
			 * 무사히 탈출했다면 좌표값을 이용해 상금 계산
			 * 
			 * 1000 4300
			 */

			for (int i = 0; i < members; i++) {
				// 플레이어마다 시작 위치 계산
				int cy = player.get(i).get(0);
				int cx = player.get(i).get(1);

				boolean exitFlag = true;

				for (int j = 0; j < player.get(i).get(2); j++) {
					int dir = table[cy][cx][0];
					int size = table[cy][cx][1];

					cy = cy + move[dir][1] * size;
					cx = cx + move[dir][0] * size;

					if (cy < 0 || cy >= rows || cx < 0 || cx >= cols) {
						exitFlag = false;
						break;
					}
					if (table[cy][cx] == null) {
						exitFlag = false;
						break;
					}
				}

				if (exitFlag) {
					int num1 = table[cy][cx][0] + 0;
					int num2 = table[cy][cx][1] + 0;

					result += num1 * 1000 + num2 * 100 - 1000;
				} else {
					result -= 1000;
				}
			}
			System.out.println(result);

		}
	}
}
