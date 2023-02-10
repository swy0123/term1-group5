import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fri_beak_1992 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[][] table = new String[n][n];
		for (int i = 0; i < n; i++) {
			table[i] = br.readLine().split("");
		}

		System.out.println(recursive(table, 0, 0, n));
	}

	private static String recursive(String[][] table, int y, int x, int size) {
		String stValue = table[y][x];
		boolean flag = false;
		label: for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (!stValue.equals(table[i][j])) {
					flag = true;
					break label;
				}
			}
		}

		// 탐색한값이 하나다.
		if (!flag) {
			return stValue;
		}
		
		StringBuilder sb = new StringBuilder();
		int newSize = size / 2;
		sb.append("(");
		sb.append(recursive(table, y, x, newSize));
		sb.append(recursive(table, y, x + newSize, newSize));
		sb.append(recursive(table, y + newSize, x, newSize));
		sb.append(recursive(table, y + newSize, x + newSize, newSize));
		sb.append(")");
		
		return sb.toString();
	}

}
