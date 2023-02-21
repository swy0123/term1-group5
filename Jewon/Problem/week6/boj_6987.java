package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
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
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Integer.parseInt(st.nextToken());
		for (int round = 0; round < 4; round++) {
			flag = false;
			
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
			if(!flag) {
				System.out.print(0 + " ");
			}
		}
	}

	private static void recur(int team1, int team2) {
		// arr == arr_temp
		if(team1 == 5 && check()) {
			System.out.print(1 + " ");
			flag = true;
			return;
		}
		
		if(team1 == 5) {
			return;
		}
		
		if(flag) {
			return;
		}
		
		
		for (int i = 0; i < 3; i++) {
			// win draw lose 처리
			if(		// i== 0 arr_temp 의 값이 arr보다 같거나 크면 안댐
					i == 0 && arr_temp[team1][0] < arr[team1][0] ||
					// i == 1 team에 있는지 여부 확인
					i == 1 && arr_temp[team1][1] < arr[team1][1] ||
					// i == 2 team에 패배의 값도 어떻게 확인
					i ==2 && arr_temp[team1][2] < arr[team1][2]
					) {
				vs(team1, team2, i);
				
				if (team2 == 5) {
					recur(team1 + 1, team1 + 2);
				} else {
					recur(team1, team2 + 1);
				}
				
				// 처리 다시 돌리기
				vs_back(team1, team2, i);			
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != arr_temp[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// arr_temp
	private static void vs(int team1, int team2, int i) {
		switch (i) {
		case 0: // win
			arr_temp[team1][0]++;
			arr_temp[team2][2]++;
			break;
		case 1: // draw
			arr_temp[team1][1]++;
			arr_temp[team2][1]++;
			break;
		case 2: // lose
			arr_temp[team1][2]++;
			arr_temp[team2][0]++;
			break;
		}
	}

	private static void vs_back(int team1, int team2, int i) {
		switch (i) {
		case 0: // win
			arr_temp[team1][0]--;
			arr_temp[team2][2]--;
			break;
		case 1: // draw
			arr_temp[team1][1]--;
			arr_temp[team2][1]--;
			break;
		case 2: // lose
			arr_temp[team1][2]--;
			arr_temp[team2][0]--;
			break;
		}
	}

}
