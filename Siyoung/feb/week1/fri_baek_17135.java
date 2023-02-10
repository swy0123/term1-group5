package algorithm.week1.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 17135 캐슬 디펜스
 */
public class fri_baek_17135 {
	static int n, m, d;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[] pos = new int[m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		archerPosition(map, pos, 0, 3, new boolean[m]);
		System.out.println(max);
	}
	
	//궁수 위치 정하기
	private static void archerPosition(int[][] map, int[] pos, int idx, int cnt, boolean[] v) {
		if(cnt == 0) {
			for(int i=0; i<v.length; i++) {
				if(v[i]) {
					pos[i] = 2;
				}
				else pos[i] = 0;
			}
			//시뮬레이션(pos)
//			for (int[] ma : map) {
//				System.out.println(Arrays.toString(ma));
//			}
			max = Math.max(max, simulator(v, map, n));
//			System.out.println(Arrays.toString(v));
		}
		
		
		for(int i=idx; i<v.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				archerPosition(map, pos, i+1, cnt-1, v);
				v[i] = false;
			}
			
		}
		
	}
	

	//시뮬레이션
	private static int simulator(boolean[] v, int[][] map, int cnt) {
//		System.out.println(Arrays.toString(v));
		
		int[][] board = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = map[i][j];
			}
		}
//		for (int[] ma : board) {
//			System.out.println(Arrays.toString(ma));
//		}
		//궁수 공격 타겟 선정
		int kill = 0;
		for(int r=0; r<cnt; r++) {
			for(int i=0; i<v.length; i++) {
				if(v[i] == false) continue;
				int[] tmp = attack(i, board);
//				System.out.println(Arrays.toString(tmp));
				if(tmp[0] == -1 || tmp[1] == -1) continue;
				board[tmp[0]][tmp[1]] = -1;
//				for (int[] ma : board) {
//					System.out.println(Arrays.toString(ma));
//				}
				
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] == -1) {
						kill++;
						board[i][j] = 0;
					}
				}
			}
			
			
//			System.out.println(kill);
			for(int i=n-1; i>=0; i--) {
				for(int j=0; j<m; j++) {
					if(i>0) {
						board[i][j] = board[i-1][j];
					}
					else {
						board[i][j] = 0;
					}
				}
			}
			
		}
//		System.out.println("-----------");
		return kill;
		
	}
	
	//공격
	private static int[] attack(int x, int[][] board) {
//		for (int[] ma : board) {
//			System.out.println(Arrays.toString(ma));
//		}
		int ci = -1, cj = -1;
		//거리 0~d;
		loop : for(int idx=0; idx<d; idx++) {
			//세로
			for(int i=0; i<=idx; i++) {
				if(n-1-i >= 0 && x-(idx-i) >= 0) {
					if(board[n-1-i][x-(idx-i)] != 0) {
						ci = n-1-i;
						cj = x-(idx-i);
//						System.out.println("cicj : "+ci+" "+cj);
						break loop;
					}
				}
			}
			for(int i=idx; i>=0; i--) {
				if(n-1-i >= 0 && x+(idx-i) < m) {
					if(board[n-1-i][x+(idx-i)] != 0) {
						ci = n-1-i;
						cj = x+(idx-i);
//						System.out.println("cicj : "+ci+" "+cj);
						break loop;
					}
				}
			}
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
		
		int[] ret = {ci, cj};
//		System.out.println(Arrays.toString(ret));
		return ret;
		
	}
	


}
