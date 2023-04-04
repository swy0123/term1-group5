
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보호필름_swea_2112 {
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int[][] map;
	static int d, w, k, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[d][w];
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = Integer.MAX_VALUE;
			solve(0, new boolean[d], 0);
			
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}
	
	//1~두께 조합
	private static void solve(int idx, boolean[] v, int cnt) {
		if(passCheck(v)) {
//			System.out.println("pass");
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			res = Math.min(res, cnt);
//			System.out.println(cnt);
			return;
		}
		if(idx==d) {
			return;
		}
		
		int[] tmp = new int[w];
		tmp = map[idx].clone();
		
		v[idx] = false;
		solve(idx+1, v, cnt);
		
		v[idx] = true;
		Arrays.fill(map[idx], 1);
		solve(idx+1, v, cnt+1);
		map[idx] = tmp.clone();
		
		Arrays.fill(map[idx], 0);
		solve(idx+1, v, cnt+1);
		map[idx] = tmp.clone();
	}

	// 합격 체크
	private static boolean passCheck(boolean[] v) {
		boolean pass = true;
		for(int j=0; j<w; j++) {
			int cnt = 1;
			boolean check = false;
			for(int i=0; i<d-1; i++) {
				if(map[i][j]==map[i+1][j]) {
					cnt++;
				}
				else {
					cnt = 1;
				}
				if(cnt == k) {
					check = true;
					continue;
				}
			}
			if(!check) {
				pass = false;
				break;
			}
		}
		
		return pass;
	}
	
	
}