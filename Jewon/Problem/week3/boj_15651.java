package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_15651 N과 M (3) 실버3
 * @author elder
 *
 */
public class boj_15651 {


	static int[] arr;
	
	// static int[] ans;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		arr = new int[M];

		func(0);
		System.out.print(sb); 
		// StringBuilder를 안쓰고 print문을 반복 호출하면 시간초과
	}

	private static void func(int depth) {
		// TODO Auto-generated method stub
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			func(depth + 1);
		}
	}


}
