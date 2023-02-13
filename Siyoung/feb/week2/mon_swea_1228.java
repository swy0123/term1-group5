package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * swea 1228. [S/W 문제해결 기본] 8일차 - 암호문1
 */
public class mon_swea_1228 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=10;
		int n, m, idx, cnt;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			m = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine().replaceAll("I " , ""));
			for(int i=0; i<m; i++) {
				idx = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
				for(int j=0; j<cnt; j++) {
					arr.add(idx+j, Integer.parseInt(st.nextToken()));
				}

			}
			System.out.print("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
		}
	}

}
