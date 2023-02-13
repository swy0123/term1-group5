import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA_1952 수영장
 * 
 * @author SSAFY
 *
 */
public class SWEA_1952 {
	static int[] pricelist = new int[4];
	static int[] monthlist = new int[12];
	static int sum;
	static int ans;
	static int last;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			sum = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < pricelist.length; i++) {
				pricelist[i] = Integer.parseInt(st.nextToken());
			}

			ans = pricelist[3];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < monthlist.length; i++) {
				monthlist[i] = Integer.parseInt(st.nextToken());
				if (monthlist[i] != 0) {
					last = i + 1;
				}
			}

			search(0);
			System.out.println("#" + test_case + " "+ ans);
		}
	}

	private static void search(int depth) {
		// TODO Auto-generated method stub
		if (depth >= last) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = depth; i < monthlist.length; i++) {
			if (monthlist[i] > 0) {
				// 이용권 1
				sum += monthlist[i] * pricelist[0];
				search(i + 1);
				sum -= monthlist[i] * pricelist[0];

				// 이용권 2
				sum += pricelist[1];
				search(i + 1);
				sum -= pricelist[1];

				// 이용권 3
				sum += pricelist[2];
				search(i + 3);
				sum -= pricelist[2];
				
				return;
			}
		}
	}


}
