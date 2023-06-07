package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_22944 죽음의 비 골드4
 * 
 * @author elder
 *
 */
public class boj_22944 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N;
	static int H;
	static int D;
//	static char[][] map; // U 우산 S나의 위치 E안전지대
	static int[] S = new int[2];
	static int[] E = new int[2];
	static int ans = Integer.MAX_VALUE;
//	static boolean[][] visit;
	static List<Integer[]> Ulist;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

//		map = new char[N][N];
//		visit = new boolean[N][N];
		Ulist = new ArrayList<Integer[]>();

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				char temp = sb.charAt(j);

				if (temp == 'S') {
					S[0] = i;
					S[1] = j;
				}

				if (temp == 'U') {
					Ulist.add(new Integer[] { i, j });
				}
				
				if (temp == 'E') {
					E[0] = i;
					E[1] = j;
				}
			}
		}
		
		used = new boolean[Ulist.size()];
		
		// row col H D dist
		dfs(S[0], S[1], H, 0, 0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}
	}

	private static void dfs(int row, int col, int h, int d, int depth) {
		if (Dist(row, col, E[0], E[1]) <= h + d) {
			// depth + Dist(row, col, E[0], E[1])
			ans = Math.min(ans, depth + Dist(row, col, E[0], E[1]));
			return;
		}
		
		for (int i = 0; i < Ulist.size(); i++) {
			int temp_dist = Dist(row, col , Ulist.get(i)[0], Ulist.get(i)[1]);
			if(used[i] == false && temp_dist <= h+d) { // 우산이 있으면서 도달 할수 있으면
				used[i] = true;
				dfs(Ulist.get(i)[0], Ulist.get(i)[1], remain(h,d, temp_dist) , D-1, depth + temp_dist);
				used[i] = false;
			}
		}
	}

	private static int remain(int hp, int depen, int temp_dist) {
		int temp = depen - temp_dist + 1; // 우산 - 데미지
		
		if(temp < 0) { // 데미지량이 우산을 넘으면
			temp = hp + temp;
		}else {
			temp = hp;
		}
		
		return temp;
	}

	private static int Dist(int row, int col, int i, int j) {
		return Math.abs(row - i) + Math.abs(col - j);
	}

}
