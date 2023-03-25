package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj_10163 색종이 브론즈1
 * 
 * @author SSAFY
 *
 */
public class boj_10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[1001][1001];
		int maxh = 0;
		int maxw = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			maxh = Math.max(maxh, x + W);
			maxw = Math.max(maxw, y + H);

			// fill
			for (int row = x; row < x + W; row++) {
				for (int col = y; col < y + H; col++) {
					map[row][col] = i;
				}
			}

		}
		//count
		int[] list = new int[N+1];
		for (int row = 0; row < maxh; row++) {
			for (int col = 0; col < maxw; col++) {
				list[map[row][col]]++;
			}
		}
		
//		System.out.println(Arrays.toString(list));
		
		// print
//		for (int row = 0; row < maxh; row++) {
//			for (int col = 0; col < maxw; col++) {
//				System.out.print(map[row][col] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

}
