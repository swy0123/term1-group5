import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * boj_12891 DNA 비밀번호 실버2
 * 
 * @author SSAFY
 *
 */
public class boj_12891 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] list = new int[4];
		int[] checklist = new int[4];
		StringBuilder sb;
		int S;
		int P;
		int cnt = 0;

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		hmap.put('A', 0);
		hmap.put('C', 1);
		hmap.put('G', 2);
		hmap.put('T', 3);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		sb = new StringBuilder(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= S - P; i++) {
			boolean flag = true;
			if (i == 0) {
				for (int j = 0; j < P; j++) {
					checklist[hmap.get(sb.charAt(j))]++;
				}
			} else {
				checklist[hmap.get(sb.charAt(i - 1))]--;
				checklist[hmap.get(sb.charAt(i + P -1))]++;
			}

			// check
			for (int j = 0; j < list.length; j++) {
				if (checklist[j] < list[j]) {
					flag = false;
				}
			}

			if (flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
