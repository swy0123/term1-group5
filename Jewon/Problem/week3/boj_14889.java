package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * boj_14889 스타트와 링크 실버2
 * 
 * @author elder
 *
 */

//Wrapper Class도 Call by Value
public class boj_14889 {
	static int[][] arr;
	static int[] S = new int[2];
	static boolean[] visit;
	static boolean[] visit2;
	static int min = Integer.MAX_VALUE;
	static int N;
	static List<Integer> steam = new ArrayList<Integer>();
	static List<Integer> lteam = new ArrayList<Integer>();
	static int lpower = 0;
	static int spower = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		visit2 = new boolean[N / 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int depth, int start) {
		// TODO Auto-generated method stub
		if (depth == N / 2) {
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					steam.add(i);
				} else {
					lteam.add(i);
				}
			}

			// team power
			dfsl(lteam, 0, 0);

			dfss(steam, 0, 0);

			int val = Math.abs(spower - lpower);
			min = Math.min(min, val);

			// 초기화
			steam.clear();
			lteam.clear();
			spower = 0;
			lpower = 0;

			return;
		}

		for (int i = start; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(depth + 1, i);
				visit[i] = false;
			}
		}
	}

	private static void dfss(List<Integer> team, int depth, int start) {
		// TODO Auto-generated method stub
		if (depth == 2) {
			spower += (arr[S[1]][S[0]] + arr[S[0]][S[1]]);
			return;
		}

		for (int i = start; i < team.size(); i++) {
			if (visit2[i] == false) {
				visit2[i] = true;
				S[depth] = team.get(i);
				dfss(team, depth + 1, i);
				visit2[i] = false;
			}
		}
	}

	private static void dfsl(List<Integer> team, int depth, int start) {
		// TODO Auto-generated method stub
		if (depth == 2) {
			lpower += (arr[S[1]][S[0]] + arr[S[0]][S[1]]);
			return;
		}

		for (int i = start; i < team.size(); i++) {
			if (visit2[i] == false) {
				visit2[i] = true;
				S[depth] = team.get(i);
				dfsl(team, depth + 1, i);
				visit2[i] = false;
			}
		}
	}

}
