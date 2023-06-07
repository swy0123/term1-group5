import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());

		int Ans = 0;
		int[] memo = new int[A];
		int[] list = new int[A];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			int here = 0;
			for (int j = 0; j < i; j++) {
				if(list[i] > list[j]) {
					here = Math.max(here, memo[j]);
				}		
			}
			memo[i] = here + 1;
			Ans = Math.max(Ans, memo[i]);
		}

//		System.out.println(Arrays.toString(memo));
		System.out.println(Ans);
	}

}
