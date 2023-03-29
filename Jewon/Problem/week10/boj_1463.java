package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * 1로 만들기
 * 
 * @author SSAFY
 *
 */

// X가 3으로 나누어 떨어지면, 3으로 나눈다.
// X가 2로 나누어 떨어지면, 2로 나눈다.
// 1을 뺀다.
public class boj_1463 {

	static int cnt = 0;
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		memo = new int[num+1];
		memo[1] = 0;
		
		find(num);

//		for (int i = 0; i <= num; i++) {
//			System.out.print(memo[i] + " ");
//		}
		System.out.println(memo[num]);
	}

	private static void find(int num) {
		for (int i = 2; i <= num; i++) {
			int minval = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				minval = Math.min(minval, memo[i/3]);
			}
			
			if (i % 2 == 0) {
				minval = Math.min(minval, memo[i/2]);
			}
			
			minval = Math.min(minval, memo[i-1]);

			memo[i] = minval + 1;
		}
	}

}
