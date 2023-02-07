package week4;

import java.util.Scanner;

/**
 * SWEA_5215 햄버거다이어트 d3
 * 
 * @author elder
 *
 */
public class SWEA_5215 {
	static int maxScore;
	static boolean[] visit;
	static int[][] items;
	static int N;
	static int L;
	static int cal;
	static int score;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			maxScore = 0;
			cal = 0;
			score = 0;

			N = sc.nextInt(); // 재료수
			L = sc.nextInt(); // 칼로리
			// 0 점수 1칼로리
			items = new int[N][2];
			visit = new boolean[N];

			for (int i = 0; i < N; i++) {
				items[i][0] = sc.nextInt();
				items[i][1] = sc.nextInt();
			}

			recur(0, 0);

			System.out.println("#" + test_case + " " + maxScore);
		}
	}

	private static void recur(int start, int prevS) {
		if (cal > L) {
			maxScore = Math.max(maxScore, score - prevS);
			return;
		} else if (start == items.length) {
			maxScore = Math.max(maxScore, score);
			return;
		}

		for (int i = start; i < items.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				cal += items[i][1];
				score += items[i][0];

				recur(i + 1, items[i][0]);

				visit[i] = false;
				cal -= items[i][1];
				score -= items[i][0];
			}
		}
	}

}
