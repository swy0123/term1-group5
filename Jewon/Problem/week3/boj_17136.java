package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17136 {
	static int[][] map = new int[10][10];
	static int[] list = {5, 5, 5, 5, 5};
	static List<Integer> results = new ArrayList<Integer>();
	static int size = 10;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(map, list,  0);

		Collections.sort(results);
		if (results.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(results.get(0));
		}

	}

	private static void func(int[][] map, int[] list, int cnt) {
		// TODO Auto-generated method stub

		// 다 붙였으면
		if (all_fill_check()) {
			results.add(cnt);
			return;
		}

		// 탐색해
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// map[i][j]
				if (map[i][j] == 1) {
					for (int s = 4; s >= 0; s--) {
						
						// 조건충족
						if (((i + s) < size) && ((j + s) < size) && check_fill(i, j, s) && (list[s] != 0)) {
							
							list[s]--;
							fill(i, j, s, 0);
							func(map, list, cnt + 1);
							list[s]++;
							fill(i, j, s, 1);
						}
					}
					return;
				}

			}
		}
		//
	}
	
	// 채워라
	private static void fill(int i, int j, int s, int n) {
		// TODO Auto-generated method stub
		for (int k = i; k <= i + s; k++) {
			for (int k2 = j; k2 <= j + s; k2++) {
				map[k][k2] = n;
			}
		}
	}
	
	
	// 전부 채워졌나
	private static boolean all_fill_check() {
		// TODO Auto-generated method stub
		for (int k = 0; k < size; k++) {
			for (int k2 = 0; k2 < size; k2++) {
				if (map[k][k2] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	// 채울 수 있나
	private static boolean check_fill(int i, int j, int s) {
		// TODO Auto-generated method stub
		for (int k = i; k <= i + s; k++) {
			for (int k2 = j; k2 <= j + s; k2++) {
				if (map[k][k2] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
