package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 배열돌리기 4
 * @author SSAFY
 *
 */
public class boj_17406 {
	static int[][] arr;
	static List<Integer[]> list;
	static List<Integer[]> Seqlist;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		list = new ArrayList<Integer[]>();
		Seqlist = new ArrayList<Integer[]>();

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			list.add(new Integer[] { r, c, s });
		}
		getrecur(0);
		for (int i = 0; i < Seqlist.size(); i++) {
			Integer[] seq = Seqlist.get(i);
			for (int ii = 0; ii < seq.length; ii++) {
				Integer[] value = list.get(seq[i]);
			}
		}
		
//			for (int cnt = 0; cnt < s; cnt++) {
//				int row = r - s + cnt;
//				int col = c - s + cnt;
//				int temp = arr[row][col];
//
//				// 왼쪽변
//				for (int go = 0; go < s * 2 - cnt * 2; go++) {
//					arr[row][col] = arr[row + 1][col];
//					row++;
//				}
//
//				// 아래변
//				for (int go = 0; go < s * 2 - cnt * 2; go++) {
//					arr[row][col] = arr[row][col + 1];
//					col++;
//				}
//
//				// 오른쪽 면
//				for (int go = 0; go < s * 2 - cnt * 2; go++) {
//					arr[row][col] = arr[row - 1][col];
//					row--;
//				}
//
//				// 위변
//				for (int go = 0; go < s * 2 - cnt * 2; go++) {
//					arr[row][col] = arr[row][col - 1];
//					col--;
//				}
//				arr[row][col + 1] = temp;
//			}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			ans = Math.min(ans, sum);
		}
		System.out.println(ans);
	}
	
	static Integer[] temp_arr = new Integer[K];
	static boolean[] visit = new boolean[K];
	
	private static void getrecur(int depth) {
		if (depth == K) {
			Seqlist.add(Arrays.copyOf(temp_arr, temp_arr.length));
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				temp_arr[depth] = i;
				visit[i] = false;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
