import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * boj_16206 롤케이크 실버1
 * 
 * @author SSAFY
 *
 */
public class boj_16206 {

	public static void main(String[] args) throws IOException {
		int cnt = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> listg = new ArrayList<Integer>();
		List<Integer> listb = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (temp % 10 == 0)
				listg.add(temp);
			else
				listb.add(temp);
		}
		
		Collections.sort(listg);
		
		for (int i = 0; i < listg.size(); i++) {
			int val = listg.get(i);
			while (val > 10 && M > 0) {
				val -= 10;
				cnt++;
				M--;

			}
			if (val == 10)
				cnt++;
		}

		for (int i = 0; i < listb.size(); i++) {
			int val = listb.get(i);
			while (val > 10 && M > 0) {
				val -= 10;
				cnt++;
				M--;
			}
		}

		System.out.println(cnt);
	}

}
