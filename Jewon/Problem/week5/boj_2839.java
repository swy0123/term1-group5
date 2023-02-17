package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_2839 설탕 배달 실버 4
 * 
 * @author SSAFY
 *
 */
public class boj_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int cnt = -1;
		int temp;

		for (int i = N / 5; i >= 0; i--) {
			// i는 5 봉지의수
			if((N - i*5)%3 == 0) {
				cnt = i;
				N -= i*5;
				cnt+= N/3;
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
