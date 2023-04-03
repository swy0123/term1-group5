package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1263_사람_네트워크 {
	static int inf = 10000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==0) map[i][j] = inf;
				}
			}
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}System.out.println();
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					if(k==i)continue;
					for(int j=0; j<n; j++) {
						if(j==k || j==i) continue;
						if(map[i][j]>map[i][k]+map[k][j]) {
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			
			int min = inf;
			for(int i=0; i<n; i++) {
				int cur = 0;
				for(int j=0; j<n; j++) {
					if(map[i][j]!=inf) {
						cur+=map[i][j];
					}
				}
				min = Math.min(min, cur);
			}
			sb.append("#"+tc+" "+min+"\n");
		};
		System.out.println(sb);
	}
}