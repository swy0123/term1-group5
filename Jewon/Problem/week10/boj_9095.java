package algorithm;

import java.util.Scanner;

public class boj_9095 {
	
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] memo = new int[11];

		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		memo[4] = 7;

		for (int i = 0; i < T; i++) {
			cnt = 0;
			int num = sc.nextInt();

			dfs(0, num);
			
			System.out.println(cnt);
		}
	}
	
	private static void dfs(int i, int num) {
		if(i > num) {
			return;
		}
		
		if(i == num) {
			cnt++;
			return;
		}
		
		
		for (int j = 1; j <= 3; j++) {
			dfs(i+j,num);
		}
	}


}
