package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA D3 1289. 원재의 메모리 복구하기
 * 
 * @author elder
 *
 */
public class SWEA_1289 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int[] list = new int[str.length()];
			int cnt = 0;
			//Arrays.fill(chars, '0');
			
			for (int i = 0; i < list.length; i++) {
				if(str.charAt(i) - '0' != list[i]) {
					Arrays.fill(list, i, list.length, str.charAt(i) - '0');
					cnt++;
				}
				
				if(str.equals(list.toString())) {
					break;
				}
			}
			
			System.out.println("#" + test_case + " "+cnt);
			
		}
	}

}
