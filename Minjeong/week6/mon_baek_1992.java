import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[][] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				nums[i][j] = tmp[j].charAt(0) - '0';
			}
		}
		
		solve(0, 0, n);
		System.out.println(sb.toString());
	}
	
	private static void solve(int x, int y, int size) {
		if (canFinish(x, y, size)) {
			sb.append(nums[x][y]);
			return;
		}
		
		sb.append("(");
		int half = size / 2;
		solve(x, y, half);
		solve(x, y + half, half);
		solve(x + half, y, half);
		solve(x + half, y + half, half);
		sb.append(")");
	}

	private static boolean canFinish(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (nums[x][y] != nums[i][j]) return false;
			}
		}
		return true;
	}
}