import java.util.Scanner;

/**
 * 
 * SWEA_1210 Ladder1 D4
 *   
 * @author SSAFY
 *
 */
public class SWEA_1210 {
	static final int size = 100;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			map = new int[size][size];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				if (map[0][i] == 1) {
					if (go(0, i)) {
						System.out.println("#" + test_case + " " + i);
						break;
					}
				}
			}
		}
	}

	private static boolean go(int row, int col) {
		if (row == map.length) {
			return false;
		}else if(map[row][col] == 2) {
			return true;
		}

		map[row][col] = 0;
		boolean temp;
		if (col - 1 >= 0 && map[row][col - 1] == 1) {
			temp = go(row, col - 1);
		} else if (col + 1 < map.length && map[row][col + 1] == 1) {
			temp = go(row, col + 1);
		} else {
			temp = go(row + 1, col);
		}

		map[row][col] = 1;
		return temp;

	}

}
