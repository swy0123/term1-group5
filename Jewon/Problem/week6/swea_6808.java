package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * 6808. 규영이와 인영이의 카드게임
 * 
 * @author elder
 *
 */
public class swea_6808 {
	static List<Integer> gyu;
	static List<Integer> inyoung;
	static int win;
	static int lose;
	static int[] arr_in;
	static boolean[] visit_in;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			win = 0;
			lose = 0;
			arr_in = new int[9];
			visit_in = new boolean[9];

			gyu = new ArrayList<>();
			inyoung = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 9; i++) {
				gyu.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= 18; i++) {
				if (!gyu.contains(i)) {
					inyoung.add(i);
				}
			}

			gyu_dfs(0);
			System.out.println("#" + test_case + " " + win + " " + lose);
		}
	}

	private static void gyu_dfs(int depth_1) {
		if (depth_1 == 9) {
			int scoreG = 0;
			int scoreI = 0;

			for (int i = 0; i < 9; i++) {
				int gyu_card = gyu.get(i);
				int in_card = inyoung.get(arr_in[i]);

				if (gyu_card > in_card) { //
					scoreG += gyu_card + in_card;
				} else {
					scoreI += gyu_card + in_card;
				}
			}

			if (scoreG > scoreI) {
				win++;
			} else if (scoreG == scoreI) {

			} else {
				lose++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visit_in[i] == false) {
				visit_in[i] = true;
				arr_in[depth_1] = i;
				gyu_dfs(depth_1 + 1);
				visit_in[i] = false;
			}
		}
	}

}
