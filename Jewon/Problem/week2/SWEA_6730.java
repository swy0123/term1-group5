package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA 6730. 장애물 경주 난이도 D3
 * 
 * @author elder
 *
 */

public class SWEA_6730 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0; // 내려가는놈
			int min = 0; // 올라가는값

			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N-1; i++) {
				int temp = Integer.parseInt(st.nextToken());

				max = Math.max(max, prev - temp); //내려가는놈
				min = Math.min(min, prev - temp); //올라가는놈

				prev = temp;
			}

			System.out.println("#" + test_case + " " + Math.abs(min) + " "+max);

		}
	}

}
