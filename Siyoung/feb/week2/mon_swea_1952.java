package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * swea 1952. [모의 SW 역량테스트] 수영장
 */
public class mon_swea_1952 {

	static int min;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] cost = new int[4];
			int[] mon = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				mon[i] = Integer.parseInt(st.nextToken());
			}
			min = cost[3];
			best(mon, cost, 0, 0);
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	
	private static void best(int[] mon, int[] cost, int sum, int idx) {
		if(idx == mon.length) {
			min = Math.min(sum, min);
			
			return;
		}

		if(mon[idx] == 0) {
			best(mon, cost, sum, idx+1);
		}
		else {
			best(mon, cost, sum+mon[idx]*cost[0], idx+1);
			best(mon, cost, sum+cost[1], idx+1);
			if(idx==11) {
				best(mon, cost, sum+cost[2], idx+1);
			}
			else if(idx==10) {
				best(mon, cost, sum+cost[2], idx+2);
			}
			else{
				best(mon, cost, sum+cost[2], idx+3);
			}
		}
		
	}

}
