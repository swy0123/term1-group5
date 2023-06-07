package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ssafy_stick {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] memo = new int[num + 3];
		memo[1] = 2;
		memo[2] = 5;
		
		for (int i = 3; i <= num; i++) {
			memo[i] = memo[i-2] + memo[i-1] * 2;
		}
		
		System.out.println(memo[num]);
	}

}
