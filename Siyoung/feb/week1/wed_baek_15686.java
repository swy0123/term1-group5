package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 15686 치킨배달
 */
public class wed_baek_15686 {
	static int m;
	static int len = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		int homecnt = 0;
		int chickcnt = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) homecnt++;
				if(map[i][j] == 2) chickcnt++;
			}
		}

		int[][] home = new int[homecnt][2]; 
		int[][] chick = new int[chickcnt][2]; 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					homecnt--;
					home[homecnt][0] = i;
					home[homecnt][1] = j;
				}
				if(map[i][j] == 2) {
					chickcnt--;
					chick[chickcnt][0] = i;
					chick[chickcnt][1] = j;
				}
			}
		}
		
		chickperm(chick, 0, 0, new boolean[chick.length], home);

		System.out.println(len);

	}
	
	//치킨집 순열
	private static void chickperm(int[][] chkarr, int idx, int cnt, boolean[] v, int[][] home) {
		if(cnt == m) {
//			for(int i=0; i<v.length; i++) {
//				System.out.print(v[i]);
//			}
			len = Math.min(len, dist(home, v, chkarr));
			
			return;
		}
		for(int i=idx; i<chkarr.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				chickperm(chkarr, i+1, cnt+1, v, home);
				v[i] = false;
			}
		}
		
	}
	
	
	//최단거리
	private static int dist(int[][] home, boolean[] v, int[][] chkarr) {
//		System.out.println("dist");
		int leng = 0;
		int cur;
		
		for(int i=0; i<home.length; i++) {
			cur = Integer.MAX_VALUE;
			for(int j=0; j<v.length; j++) {
				if(v[j]) {
					cur = Math.min(cur, Math.abs(home[i][0]-chkarr[j][0]) + Math.abs(home[i][1]-chkarr[j][1]));  
				}
			}
//			System.out.println(cur);
			leng+=cur;
		}
		return leng;
	}
	
	//거리 비교
	

}
