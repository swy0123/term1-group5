package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 월드컵 boj_6987 골드5
 * 
 * @author SSAFY
 *
 */

public class boj_6987 {

	static int[][] arr_temp;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Integer.parseInt(st.nextToken());
		for (int round = 0; round < 4; round++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[6][3];
			arr_temp = new int[6][3];

			boolean ans = true;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			recur(0, 1);

		}
	}

	private static void recur(int team1, int team2) {

		for (int i = 0; i < 3; i++) {
			// win draw lose 처리
			vs(team1, team2, i);

			if (team2 == 5) {
				recur(team1 + 1, team1 + 2);
			} else {
				recur(team1, team2 + 1);
			}

			// 처리 다리 돌리기
			vs_back(team1, team2, i);
		}
	}

	private static void vs_back(int team1, int team2, int i) {
		switch (i) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		}
	}

	private static void vs(int team1, int team2, int i) {
		switch (i) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		}
	}

}
