import java.util.Scanner;

public class Main {
	static int N, res;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		solve(0);
		System.out.println(res);
	}
	
	public static void solve(int r) {
		// basis part
		if (r == N) {
			res++;
			return;
		}
		
		// inductive part
		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				map[r][c] = 1;
				solve(r + 1);
				map[r][c] = 0;	
			}
		}
	}

	// r과 c 위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	// 상, 좌, 상좌, 상우
	// 퀸이 있으면 false
	// 없으면 true
	private static boolean check(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (map[i][c] == 1) return false;
		}
		
		for (int i = 0; i < c; i++) {
			if (map[r][i] == 1) return false;
		}
		
		int r2 = r;
		int c2 = c;
		while(--r >=0 && --c >= 0) {
			if (map[r][c] == 1) return false;
		}
		
		while(--r2 >=0 && ++c2 < N) {
			if (map[r2][c2] == 1) return false;
		}
		
		return true;
	}
}
