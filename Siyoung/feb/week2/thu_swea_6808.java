package algorithm.tmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * swea 6808. 규영이와 인영이의 카드게임
 */

public class thu_swea_6808 {
	
	static int win, lose;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int[] icard = new int[9];
			int[] card = new int[9];
			boolean[] check = new boolean[19];
			win = 0;
			lose = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				icard[i] = Integer.parseInt(st.nextToken());
				check[icard[i]] = true;
			}
			int cnt = 0;
			for(int i=1; i<19; i++) {
				if(check[i]) continue;
				else card[cnt++] = i;
			}
			
//			System.out.println(Arrays.toString(card));
		
			per(icard, card, new boolean[9], new int[9], 0);
			
			System.out.println("#"+test_case+" "+lose+" "+win);
		}
	}
	
	
	private static void per(int[] icard, int[] card, boolean[] v, int[] deck, int cnt) {
		if(cnt == 9) {
//			System.out.println(Arrays.toString(deck));
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<9; i++) {
				if(icard[i]<deck[i]) sum1 += (icard[i]+deck[i]);
				else sum2 += (icard[i]+deck[i]);
			}
			if(sum1>sum2)win++;
			else lose++;
			return;
					
		}
		
		for(int i=0; i<9; i++) {
			if(!v[i]) {
				v[i] = true;
				deck[cnt] = card[i];
				per(icard, card, v, deck, cnt+1);
				v[i] = false;
			}
		}
	}
	
	

}