import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int result = Integer.MAX_VALUE;
	static List<int[]> list;
	static int n, m, k;
	static int[][] arr, tmp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		tmp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[]{r, c, s});
		}
		
		comb(0, list.size(), new int[list.size()], new boolean[list.size()]);
		
		System.out.println(result);
	}
	
	private static void comb(int depth, int size, int[] res, boolean[] v) {
		if (depth == size) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			
			// 조합 순으로 배열 회전
			for (int i = 0; i < size; i++) {
				int[] item = list.get(res[i]);
				rotate(item[0] - 1, item[1] - 1, item[2]);
			}
			
			// 배열값 계산
			for (int i = 0; i < tmp.length; i++) {
				int sum = 0;
				for (int j = 0; j < tmp[0].length; j++) {
					sum += tmp[i][j];
				}
				result = Math.min(result, sum);
			}
			return;
		}
		
		for (int i = 0; i < size; i++) {
			if (!v[i]) {
				v[i] = true;
				res[depth] = i;
				comb(depth + 1, size, res, v);
				v[i] = false;
			}
		}
	}
	
	private static void rotate(int r, int c, int s) {
		for (int cnt = 1; cnt <= s; cnt++) {
			int tmpVal = tmp[r - cnt][c + cnt];
			// 상
			for (int i = c + cnt - 1; i >= c - cnt; i--) {
				tmp[r - cnt][i + 1] = tmp[r - cnt][i];
			}
			// 좌
			for (int i = r - cnt + 1; i <= r + cnt; i++) {
				tmp[i - 1][c - cnt] = tmp[i][c - cnt];
			}
			
			// 하
			for (int i = c - cnt + 1; i <= c + cnt; i++) {
				tmp[r + cnt][i - 1] = tmp[r + cnt][i];
			}
			
			// 우
			for (int i = r + cnt - 1; i >= r - cnt; i--) {
				tmp[i + 1][c + cnt] = tmp[i][c + cnt];
			}
			tmp[r - cnt + 1][c + cnt] = tmpVal;
		}
	}
}