import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[N+1];
		int[] memo1 = new int[N+1];
		int[] memo2 = new int[N+1];

		for (int i = 0; i < N; i++) {
			list[i+1] = Integer.parseInt(br.readLine());
		}
		
		memo1[1] = list[1];
		memo2[1] = list[1];

		for (int i = 2; i <= N; i++) {
			memo1[i] = memo2[i-1] + list[i];
			memo2[i] = Math.max(memo1[i-2], memo2[i-2]) + list[i];
		}
		
		System.out.println(Math.max(memo1[N], memo2[N]));
		
	}

}
