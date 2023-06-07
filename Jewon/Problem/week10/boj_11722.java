import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_11722 가장 긴 감소하는 부분 수열 실버 2
 * 
 * @author SSAFY
 *
 */
public class boj_11722 {

	static int N;
	static int[] list;
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		memo = new int[N];
		memo[0] = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < memo.length; i++) {
			int here = 0;
			
			for (int j = 0; j < i; j++) {
				if(list[j] > list[i]) {
					here = Math.max(here, memo[j]);
				}
			}
			memo[i] = here + 1;
		}
		
		
		System.out.println(Arrays.stream(memo).max().getAsInt());
	}

}
