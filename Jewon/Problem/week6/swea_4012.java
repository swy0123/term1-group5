package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * swea_4012 [모의 SW 역량테스트] 요리사
 * 
 * @author SSAFY
 *
 */
public class swea_4012 {
	static int[][] table;
	static int N;
	static boolean[] visit;
	static int min_diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			visit = new boolean[N];
			min_diff = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);

			System.out.println("#" + test_case + " " + min_diff);
		}
	}

	// 재료 나눔
	private static void combination(int depth, int start) {
		if (depth == N / 2) {
			score(visit);
			return;
		}

//		if (start >= N / 2 ) {
//			return;
//		}
		
		for (int i = start; i < N; i++) {
			visit[i] = true;
			combination(depth + 1, i + 1);
			visit[i] = false;
		}
	}

	// 나눈 재료의 맛을 구함
	private static void score(boolean[] visit) {
		// 2개를 골라서 합쳐버려
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < visit.length; i++) {
			if (visit[i]) {
				list1.add(i);
			} else {
				list2.add(i);
			}
		}
		all_mat = 0;
		sum_all(list1, 0, 0, 0);
		int temp1 = all_mat;
//		System.out.println(Arrays.toString(list1.toArray()) + " " + temp1);
		
		all_mat = 0;
		sum_all(list2, 0, 0, 0);
		int temp2 = all_mat;
//		System.out.println(Arrays.toString(list2.toArray()) + " " + temp2);
		
		int diff = Math.abs(temp1 - temp2);
		min_diff = Math.min(diff, min_diff);
//		System.out.println("========" + diff + "=======");
	}

	// 두개씩 골라서 모든 맛의 합을 구함
	static int[] temp_arr = new int[2];
	static int all_mat = 0;
	
	private static void sum_all(List<Integer> list, int depth, int start, int sum) {
		if (depth == 2) {
			int temp = table[temp_arr[0]][temp_arr[1]] + table[temp_arr[1]][temp_arr[0]];
//			System.out.println(temp_arr[0] + " " +temp_arr[1]  + " " + temp);
			all_mat += temp;
			return ;
		}

		for (int i = start; i < list.size(); i++) {
			temp_arr[depth] = list.get(i);
			sum_all(list, depth+1, i + 1, sum);
		}


	}

}
