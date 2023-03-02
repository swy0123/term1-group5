package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_17135 캐슬 디펜스 골드 3
 * 
 * @author SSAFY
 *
 */
public class boj_17135 {

	static int N, M, D;

	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	static int Ans = -1;
	static List<Point> Enermy;
	static boolean[] Enermy_status;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		Enermy = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					Enermy.add(new Point(i, j));
				}
			}
		}
//		System.out.println(Arrays.toString(Enermy.toArray()));
//		visit = new boolean[Enermy.size()];
		arr = new int[3];
		combination(0, 0);
		System.out.println(Ans);
	}

	static int[] arr;
	static List<Integer> depth_list;
	private static void combination(int depth, int start) {
		if (depth == 3) {
//			System.out.println("============================");
			Enermy_status = new boolean[Enermy.size()];
			int cnt = 0;
			// 궁수 배치 완료
			for (int i = N; i > 0; i--) { // row
				depth_list = new ArrayList<Integer>();
				for (int A = 0; A < arr.length; A++) {
					int minD = Integer.MAX_VALUE;
					int minIdx = -1;
					for (int E = 0; E < Enermy_status.length; E++) {
						// i, arr[A] - Enermy[E]
						if (!Enermy_status[E] && Enermy.get(E).row < i) {
							int dist = Math.abs(i - Enermy.get(E).row) + Math.abs(arr[A] - Enermy.get(E).col);
							if (dist <= D) {
								if (minD > dist) {
									minD = dist;
									minIdx = E;
								} else if (minD == dist && minD != Integer.MAX_VALUE) {
									if (Enermy.get(minIdx).col > Enermy.get(E).col) {
										minIdx = E;
									}
								}
							}
						}
					}

					if (minIdx == -1)
						continue;
//					Enermy_status[minIdx] = true;
//					cnt++;
					depth_list.add(minIdx);
				}
				for (int j = 0; j < depth_list.size(); j++) {
					if(!Enermy_status[depth_list.get(j)]) {
						Enermy_status[depth_list.get(j)] = true;
						cnt++;
					}
				}
//				print();
			}

//			System.out.println(cnt + " : " + Arrays.toString(arr));
			Ans = Math.max(Ans, cnt);
			return;
		}

		for (int i = start; i < M; i++) {
			arr[depth] = i;
			combination(depth + 1, i + 1);
		}
	}

	private static void print() {
		for (int i = 0; i < Enermy_status.length; i++) {
			if (Enermy_status[i]) {
				System.out.print(Enermy.get(i) + " ");
			}
		}
		System.out.println();
	}

}
