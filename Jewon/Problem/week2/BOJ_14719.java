package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 빗물 boj 14719 gold5
 * 
 * @author elder
 *
 */
public class BOJ_14719 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[W];
		int maxidx = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[maxidx] < arr[i]) {
				maxidx = i;
			}
		}

		int sum = 0, tempidx = 0;
		for (int i = 1; i < maxidx; i++) {
			if (arr[tempidx] > arr[i]) {
				sum += arr[tempidx] - arr[i];
			} else {
				tempidx = i;
			}
		}

		tempidx = arr.length - 1;
		for (int i = tempidx - 1; i > maxidx; i--) {
			if (arr[tempidx] > arr[i]) {
				sum += arr[tempidx] - arr[i];
			} else {
				tempidx = i;
			}
		}
		
		System.out.println(sum);

	}

}
