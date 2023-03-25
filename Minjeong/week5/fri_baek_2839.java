import java.util.Scanner;

public class Main {
static int res = Integer.MAX_VALUE, n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
//		find(0, 0, 0);
//		if (res == Integer.MAX_VALUE) System.out.println(-1);
//		else System.out.println(res);
		
		int[] res = new int[5000];
		for (int i = 0; i <= n; i++) res[i] = 10000;
		res[3] = res[5] = 1;
		for (int i = 6; i <= n; i++) {
			res[i] = Math.min(res[i - 3], res[i - 5]) + 1;
		}
		if (res[n] == 10000) System.out.println(-1);
		else System.out.println(res[n]);
	}

//	private static void find(int w, int a, int b) {
//		if (w > res) return;
//		if (w == n) {
//			res = Math.min(res, a + b);
//			return;
//		}
//		
//		if (w > n) return;
//		
//		find(w + 3, a + 1, b);
//		find(w + 5, a, b + 1);
//	}
}