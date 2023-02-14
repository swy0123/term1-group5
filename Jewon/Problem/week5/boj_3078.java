import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * boj_3078 좋은 친구 골드4
 * @author SSAFY
 *
 */
public class boj_3078 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long ans = 0;
		
		int[] list = new int[N];
		int[] listk = new int[21];
		for (int times = 0; times <= K; times++) {
			String name = br.readLine();
			list[times] = name.length();
			ans += listk[list[times]];
			listk[list[times]]++;
		}
		
		for (int times = K+1; times < N; times++) {
			String name = br.readLine();
			listk[list[times-K-1]]--;
			list[times] = name.length();
			ans += listk[list[times]];
			listk[list[times]]++;
		}
		
		System.out.println(ans);
	}

}
