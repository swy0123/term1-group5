import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		solve(0, 0, (int) Math.pow(2, n), 0);
	}

	private static void solve(int x, int y, int size, int label) {
		if (flag == true) return;
		if ( x + size < r || y + size < c) return;

		if (size == 1) {
			if (x == r && y == c) {
				System.out.println(label);
				flag = true;
				return;
			}
			return;
		}
		

		int half = size / 2;
		solve(x, y, half, label);
		solve(x, y + half, half, label + (half * half));
		solve(x + half, y, half, label + (half * half) * 2);
		solve(x + half, y + half, half, label + (half * half) * 3);
	}
}