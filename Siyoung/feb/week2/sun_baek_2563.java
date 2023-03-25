package feb.week2.sat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 2563 색종이
 */
public class sun_baek_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];
	
		int l, b;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			for(int j=b; j<b+10; j++) {
				for(int k=l; k<l+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for (int[] is : map) {
			for (int is2 : is) {
				if(is2 == 1) sum++;
			}
			
		}
		System.out.println(sum);
	}

}
