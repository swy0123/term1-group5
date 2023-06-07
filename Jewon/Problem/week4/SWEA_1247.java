import java.util.Scanner;

/**
 * 
 * SWEA_1247 최적 경로 D5
 * @author SSAFY
 *
 */
class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int howDist(Point t) {
		return Math.abs(this.x - t.x) + Math.abs(this.y - t.y);
	}
}

public class SWEA_1247 {

	static Integer[] arr;
	static boolean[] visit;
	static Point startp;
	static Point endp;
	static Point[] customers;
	static int minDist;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			minDist = Integer.MAX_VALUE;

			arr = new Integer[N];
			visit = new boolean[N];
			startp = new Point(sc.nextInt(), sc.nextInt());
			endp = new Point(sc.nextInt(), sc.nextInt());

			customers = new Point[N];
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			// get 순열생성
			getrecur(0, N);

			System.out.println("#" + test_case + " " + minDist);
		}
	}

	private static int getDistance(Integer[] nums) {
		// TODO Auto-generated method stub
		int dist = 0;

		dist += startp.howDist(customers[nums[0]]);

		for (int i = 0; i < nums.length - 1; i++) {
			dist += customers[nums[i]].howDist(customers[nums[i + 1]]);
		}

		dist += customers[nums[nums.length - 1]].howDist(endp);

		return dist;
	}

	private static void getrecur(int depth, int N) {
		// TODO Auto-generated method stub
		if (depth == N) {
			minDist = Math.min(getDistance(arr), minDist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				arr[depth] = i;
				getrecur(depth + 1, N);

				visit[i] = false;
			}
		}
	}

}
