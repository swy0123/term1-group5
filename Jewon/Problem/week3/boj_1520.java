package IM;

import java.util.Scanner;

public class boj_1520 {
	static int[][] arr;
	static boolean[] visit;
	static int ans = 0;
	static int N;
	static int M;
	static int[][] delta = {{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0);
		
		System.out.println(ans);
	}

	private static void dfs(int depth, int i, int j) {
		// TODO Auto-generated method stub
		if (i == (N - 1) && j == (M - 1)) {
			ans++;
			return;
		}
		
		for(int time = 0; time <3 ; time ++) {
			// arr[i+delta[time][0]][j + delta[time][1]]
			if(i+delta[time][0] >= 0 && i+delta[time][0] < N && j + delta[time][1] >= 0 && j + delta[time][1] < M) {			
				if (arr[i][j] > arr[i + delta[time][0]][j + delta[time][1]]) {
					dfs(depth + 1, i + delta[time][0], j + delta[time][1]);
				}
			}
		}
	}

}
