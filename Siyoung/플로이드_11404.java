import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 플로이드_11404 {
	static int n, m, res, inf = 99999999;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int[] is : map) {
			Arrays.fill(is, inf);
		}
		int from, to, w;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken())-1;
			to = Integer.parseInt(st.nextToken())-1;
			w = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(w, map[from][to]);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j || map[i][j] == 0) map[i][j] = inf;
			}
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(k==i) continue;
				for(int j=0; j<n; j++) {
					if(i==j || j==k) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == inf) System.out.print("0 ");
				else System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}

