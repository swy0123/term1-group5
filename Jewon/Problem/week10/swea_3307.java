package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * swea_3307 최장 증가 부분 수열 
 * 
 * @author SSAFY
 *
 */
public class swea_3307 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			int[] memo = new int[N];
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				
				if(i == 0) {
					memo[0] = list[0];
					idx++;
				}
				
				if(memo[idx-1] < list[i]) {
					memo[idx] = list[i];
					idx++;
				}else {
					for (int j = 0; j <= idx-1; j++) {
						if(memo[j] > list[i]) {
							memo[j] = list[i];
							break;
						}
					}
				}
			}
			
			System.out.println("#"+test_case + " " + idx);
			
		}
	}

}
