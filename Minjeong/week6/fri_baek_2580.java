import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] board = new int[9][9];
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	static List<Pair> q = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) q.add(new Pair(i, j));
			}
		}

		int cnt = q.size();
		solve(cnt, 0);
		//System.out.println(sb.toString());
	}

	private static void solve(int cnt, int idx) {
		if (flag) return;
		
		if (cnt == 0) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			flag = true;
			System.out.println(sb.toString());
			System.exit(0);
		}
		
			int x = q.get(idx).x;
			int y = q.get(idx).y;

			for (int i = 1; i <= 9; i++) {
				if (canFill(x, y, i)) {
					board[x][y] = i;
					solve(cnt - 1, idx + 1);
					board[x][y] = 0;
				}
			}
		//}
	}
	
	private static boolean canFill(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			// 가로 확인
			if (board[x][i] == num) return false;
			// 세로 확인
			if (board[i][y] == num) return false;
		}
		
		// 3x3 정사각형 확인
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (board[i][j] == num) return false;
			}
		}
		
		return true;
	}
}