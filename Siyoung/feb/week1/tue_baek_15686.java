package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tue_baek_15686 {
	private static class spot{
		int i;
		int j;
	}
	static int m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		spot[] home = new spot[n*2]; 
		spot[] chick = new spot[13]; 
		int homecnt = 0;
		int chickcnt = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(br.readLine());
				if(map[i][j] == 1) homecnt++;
				if(map[i][j] == 2) chickcnt++;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					home[homecnt].i = i;
					home[homecnt].j = j;
					homecnt--;
				}
				if(map[i][j] == 2) {
					chick[chickcnt].i = i;
					chick[chickcnt].j = j;
					chickcnt--;
				}
			}
		}
		
		
		

	}
	
	//치킨집 순열
	private static void chickperm(boolean[] check, spot[] chkarr, spot[] newarr, int cnt) {
		if(cnt == m) {
			System.out.println(chkarr.toString());
		}
		
		for(int i=0; i<check.length; i++) {
			if(check[i]==false) {
				check[i] = true;
				newarr[cnt] = chkarr[i];
				chickperm(check, chkarr, newarr, cnt+1);
				check[i] = false;
			}
			
		}
		
		
		
	}
	
	
	//최단거리
	
	
	//거리 비교
	

}
