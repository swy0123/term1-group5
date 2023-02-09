package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * boj_9663 N-Queen 골드4
 * 
 * @author elder
 *
 */
public class boj_9663 {
	static int N;
	static int[] arr;
	static boolean[] visit;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		nqueen(0);

		System.out.println(cnt);
	}

	private static void nqueen(int depth) {
		// TODO Auto-generated method stub
		if (depth == N) {
			cnt++;
//			System.out.println(Arrays.toString(arr));
			return;
		}

		// depth는 행 arr들어갈 값은 열값
		// 둔곳은 안댐
		// 대각선 안댐
		for (int i = 0; i < N; i++) {
			if (visit[i] == false && check(depth, i)) {
				visit[i] = true;
				arr[depth] = i;
				nqueen(depth + 1);

				visit[i] = false;
			}
		}
	}

	private static boolean check(int depth, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < depth; j++) {
			if (Math.abs(arr[j] - i) == Math.abs(j - depth)) {
				return false;
			}
		}
		return true;
	}

}
