package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY
 *
 */
public class 알고스탁 {

	static int Ms;
	static int Ma;
	static int N, L;
	static int[][] list;

	static class option implements Comparable<option> {
		int plus;
		int price;

		@Override
		public String toString() {
			return "option [plus=" + plus + ", price=" + price + "]";
		}

		public option(int plus, int price) {
			super();
			this.plus = plus;
			this.price = price;
		}

		@Override
		public int compareTo(option o) {
			if (this.plus != o.plus) {

				// 이익이 다르면 이익이 큰것이 앞으로
				return Integer.compare(o.plus, this.plus);
			} else {
				// 이익이 같으면 싼것부터
				return Integer.compare(this.price, o.price);
			}
		}

	}

	static int Ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = 0;

			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			list = new int[N][L + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L + 1; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int day = 0; day < L; day++) {
				PriorityQueue<option> q = new PriorityQueue<option>();
				for (int i = 0; i < N; i++) {
					int plus = list[i][day + 1] - list[i][day];
					if (plus > 0) {
						q.offer(new option(plus, list[i][day]));
					}
				}
//				System.out.println(Arrays.toString(q.toArray()));
				int size = q.size();
				int has_money = Ms + day * Ma + Ans;
				int plus_value = 0;
				for (int i = 0; i < size; i++) {
					option o = q.poll();

					int temp_cnt = has_money / o.price;
					plus_value += temp_cnt * o.plus;
					has_money -= temp_cnt * o.price;
				}
//				System.out.println(plus_value);
				Ans += plus_value;
			}

			System.out.println("#" + test_case + " " + Ans);
		}
	}

}
