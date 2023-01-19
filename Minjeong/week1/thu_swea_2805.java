import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int res = 0, n;
			n = sc.nextInt();
			int[][] farm = new int[n][n];
			for (int i = 0; i < n; i++) {
				String tmp = sc.next();
				for (int j = 0; j < n; j++) {
					farm[i][j] = tmp.charAt(j) - '0';
				}
			}
			
			int cnt = 1;
			for (int i = 0; i < farm.length; i++) {
				if (i <= n / 2) {
					int gap = (n - cnt) / 2;
					for (int j = gap; j < gap + cnt; j++) {
						res += farm[i][j];
					}
					cnt += 2;
					if (i == n / 2) cnt = n;
				}
				else {
					cnt -= 2;
					int gap = (n - cnt) / 2;
					for (int j = gap; j < gap + cnt; j++) {
						res += farm[i][j];
					}
				}
			}
			
			System.out.println("#" + testCase + " " + res);
		}
	}
}
