import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 스도쿠
public class tue_beak_2580 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] table = new int[9][9];
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 0) {
					list.add(new int[] { i, j });
				}
				table[i][j] = input;
			}
		}
		dfs(list, 0, table);
	}

	private static void dfs(List<int[]> list, int index, int[][] table) {
		if (index == list.size()) {
			print(table);
			System.exit(0);
		}

		int[] coord = list.get(index);
		int y = coord[0];
		int x = coord[1];

		for (int i = 1; i < 10; i++) {
			if (checkRow(table, y, x, i) && checkCol(table, y, x, i) && checkSquare(table, y, x, i)) {
				table[y][x] = i;
				dfs(list, index + 1, table);
				table[y][x] = 0;
			}
		}
	}

	private static boolean checkRow(int[][] table, int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (table[y][i] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int[][] table, int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (table[i][x] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkSquare(int[][] table, int y, int x, int num) {
		int startY = (y / 3) * 3;
		int startX = (x / 3) * 3;

		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (table[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print(int[][] table) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
