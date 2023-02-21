package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj_3040 백설 공주와 일곱 난쟁이 브론즈 2
 * 
 * @author SSAFY
 *
 */
public class boj_3040 {
	static int[] arr = new int[9];
	static boolean[] visit = new boolean[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		recur(0,0);
	}
	
	private static void recur(int depth, int start) {
		if(depth == 7) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(visit[i]) {
					sum += arr[i];
				}
			}
			
			if(sum == 100) {
				for (int i = 0; i < arr.length; i++) {
					if(visit[i]) {
						System.out.println(arr[i]);
					}
				}
				System.exit(0);
			}
			
		}
		
		for (int i = start; i < arr.length; i++) {
			visit[i] = true;
			recur(depth+1, i+1);
			visit[i] = false;
		}
		
	}

}
